// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package tribefire.extension.antivirus.model.deployment.service;

import com.braintribe.model.extensiondeployment.check.CheckProcessor;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface HealthCheckProcessor extends CheckProcessor {

	final EntityType<HealthCheckProcessor> T = EntityTypes.T(HealthCheckProcessor.class);

	String providerSpecificationType = "providerSpecificationType";
	String providerModuleSpecificationMethod = "providerModuleSpecificationMethod";
	String providerActivatedMethod = "providerActivatedMethod";

	String getProviderSpecificationType();
	void setProviderSpecificationType(String providerSpecificationType);

	String getProviderModuleSpecificationMethod();
	void setProviderModuleSpecificationMethod(String providerModuleSpecificationMethod);

	String getProviderActivatedMethod();
	void setProviderActivatedMethod(String providerActivatedMethod);
}
