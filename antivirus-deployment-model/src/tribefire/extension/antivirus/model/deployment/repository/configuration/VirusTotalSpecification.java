// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package tribefire.extension.antivirus.model.deployment.repository.configuration;

import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.meta.Confidential;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.annotation.meta.Mandatory;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface VirusTotalSpecification extends ProviderSpecification {

	EntityType<VirusTotalSpecification> T = EntityTypes.T(VirusTotalSpecification.class);

	String apiKey = "apiKey";
	String pollIntervalInSec = "pollIntervalInSec";
	String pollDurationInSec = "pollDurationInSec";

	@Mandatory
	@Name("API key")
	@Confidential
	String getApiKey();
	void setApiKey(String apiKey);

	@Mandatory
	@Name("Poll Interval")
	@Description("Poll interval in seconds")
	@Initializer("2")
	int getPollIntervalInSec();
	void setPollIntervalInSec(int pollIntervalInSec);

	@Mandatory
	@Name("Poll Duration")
	@Description("Max Poll duration in seconds")
	@Initializer("60")
	int getPollDurationInSec();
	void setPollDurationInSec(int pollDurationInSec);
}
