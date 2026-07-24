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
package tribefire.extension.antivirus.model.deployment.repository.configuration;

import java.util.List;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.annotation.meta.Mandatory;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

/**
 * Configures an antivirus processor and binds it to a service domain.
 * <p>
 * The package is intentionally shared with the existing provider configuration types. Those
 * types are also reused by the classic deployment model, so moving them would break model
 * compatibility.
 */
@SelectiveInformation("Antivirus for ${accessId}")
public interface AntivirusConfiguration extends GenericEntity {

	EntityType<AntivirusConfiguration> T = EntityTypes.T(AntivirusConfiguration.class);

	@Mandatory
	@Name("Access ID")
	@Description("Access whose service model receives the antivirus requests and processor binding.")
	String getAccessId();
	void setAccessId(String accessId);

	@Mandatory
	@Name("Provider Specifications")
	@Description("Providers used when a request does not specify providers of its own.")
	List<ProviderSpecification> getProviderSpecifications();
	void setProviderSpecifications(List<ProviderSpecification> providerSpecifications);
}
