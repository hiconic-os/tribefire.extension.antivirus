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
package tribefire.extension.antivirus.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import com.braintribe.model.resource.Resource;

import tribefire.extension.antivirus.connector.api.AntivirusConnector;
import tribefire.extension.antivirus.connector.api.AntivirusHealthCheckResult;
import tribefire.extension.antivirus.model.deployment.repository.configuration.ClamAVSpecification;
import tribefire.extension.antivirus.model.deployment.repository.configuration.CloudmersiveSpecification;
import tribefire.extension.antivirus.model.deployment.repository.configuration.ProviderSpecification;
import tribefire.extension.antivirus.model.deployment.repository.configuration.VirusTotalSpecification;
import tribefire.extension.antivirus.model.service.result.AbstractAntivirusResult;
import tribefire.extension.antivirus.service.connector.clamav.ClamAVExpert;
import tribefire.extension.antivirus.service.connector.cloudmersive.CloudmersiveExpert;
import tribefire.extension.antivirus.service.connector.virustotal.VirusTotalExpert;

public final class AntivirusHealthChecks {

	private AntivirusHealthChecks() {
	}

	public static List<AntivirusHealthCheckResult> check(List<ProviderSpecification> providers) {
		Resource resource = Resource.T.create();
		resource.assignTransientSource(() -> new ByteArrayInputStream("healthcheck".getBytes()));

		List<AntivirusHealthCheckResult> results = new ArrayList<>();
		for (ProviderSpecification provider : providers) {
			AntivirusConnector<? extends AbstractAntivirusResult> expert;
			if (provider instanceof ClamAVSpecification) {
				expert = ClamAVExpert.forHealthCheck((ClamAVSpecification) provider, resource);
			} else if (provider instanceof CloudmersiveSpecification) {
				expert = CloudmersiveExpert.forHealthCheck((CloudmersiveSpecification) provider, resource);
			} else if (provider instanceof VirusTotalSpecification) {
				expert = VirusTotalExpert.forHealthCheck((VirusTotalSpecification) provider, resource);
			} else {
				throw new IllegalStateException("ProviderSpecification: '" + provider + "' not supported");
			}
			results.add(expert.actualHealth());
		}
		return results;
	}
}
