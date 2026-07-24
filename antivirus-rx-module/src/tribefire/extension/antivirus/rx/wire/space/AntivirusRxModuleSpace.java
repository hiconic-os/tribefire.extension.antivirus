// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
package tribefire.extension.antivirus.rx.wire.space;

import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import hiconic.rx.access.module.api.AccessContract;
import hiconic.rx.access.module.api.AccessServiceModelConfiguration;
import hiconic.rx.check.api.CheckContract;
import hiconic.rx.check.model.aspect.CheckCoverage;
import hiconic.rx.check.model.aspect.CheckLatency;
import hiconic.rx.module.api.service.ModelConfigurations;
import hiconic.rx.module.api.wire.RxModuleContract;
import hiconic.rx.module.api.wire.RxPlatformContract;
import tribefire.extension.antivirus.model.deployment.repository.configuration.AntivirusConfiguration;
import tribefire.extension.antivirus.model.service.request.AntivirusRequest;
import tribefire.extension.antivirus.rx.processing.AntivirusCheckProcessor;
import tribefire.extension.antivirus.rx.processing.AntivirusCheckSymbol;
import tribefire.extension.antivirus.service.AntivirusProcessor;

@Managed
public class AntivirusRxModuleSpace implements RxModuleContract {

	@Import private RxPlatformContract platform;
	@Import private AccessContract access;
	@Import private CheckContract check;

	@Override
	public void configureModels(ModelConfigurations configurations) {
		AccessServiceModelConfiguration serviceModel =
				access.accessModelConfigurations().serviceModelConfiguration(configuration().getAccessId());
		serviceModel.addModelByName("tribefire.extension.antivirus:antivirus-service-model");
		serviceModel.bindAccessRequest(AntivirusRequest.T, this::antivirusProcessor);
	}

	@Override
	public void onDeploy() {
		check.checkProcessorRegistry().registerProcessor(AntivirusCheckSymbol.antivirus, antivirusCheckProcessor(),
				CheckCoverage.connectivity, CheckLatency.moderate);
	}

	@Managed
	private AntivirusCheckProcessor antivirusCheckProcessor() {
		AntivirusCheckProcessor bean = new AntivirusCheckProcessor();
		bean.setProviderSpecifications(configuration().getProviderSpecifications());
		return bean;
	}

	@Managed
	private AntivirusProcessor antivirusProcessor() {
		AntivirusProcessor bean = new AntivirusProcessor();
		bean.setProviderSpecifications(configuration().getProviderSpecifications());
		return bean;
	}

	@Managed
	private AntivirusConfiguration configuration() {
		return platform.configuration().readConfig(AntivirusConfiguration.T).get();
	}
}
