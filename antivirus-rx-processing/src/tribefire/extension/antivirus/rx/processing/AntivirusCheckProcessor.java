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
package tribefire.extension.antivirus.rx.processing;

import java.util.List;

import com.braintribe.cfg.Required;
import com.braintribe.model.processing.service.api.ServiceRequestContext;

import hiconic.rx.check.api.CheckProcessor;
import hiconic.rx.check.model.result.CheckResult;
import hiconic.rx.check.model.result.CheckResultEntry;
import hiconic.rx.check.model.result.CheckStatus;
import tribefire.extension.antivirus.connector.api.AntivirusHealthCheckResult;
import tribefire.extension.antivirus.model.deployment.repository.configuration.ProviderSpecification;
import tribefire.extension.antivirus.service.AntivirusHealthChecks;

public class AntivirusCheckProcessor implements CheckProcessor {

	private List<ProviderSpecification> providerSpecifications;

	@Override
	public CheckResult check(ServiceRequestContext context) {
		CheckResult result = CheckResult.T.create();
		AntivirusHealthChecks.check(providerSpecifications).stream().map(this::toRxResult).forEach(result.getEntries()::add);
		return result;
	}

	private CheckResultEntry toRxResult(AntivirusHealthCheckResult health) {
		CheckResultEntry result = CheckResultEntry.T.create();
		result.setName(health.getName());
		result.setCheckStatus(CheckStatus.valueOf(health.getStatus().name()));
		result.setMessage(health.getMessage());
		result.setDetails(health.getDetails());
		return result;
	}

	@Required
	public void setProviderSpecifications(List<ProviderSpecification> providerSpecifications) {
		this.providerSpecifications = providerSpecifications;
	}
}
