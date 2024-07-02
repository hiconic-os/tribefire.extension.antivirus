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
package tribefire.extension.antivirus.model.service.result;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.Abstract;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.annotation.meta.Mandatory;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.annotation.meta.Unmodifiable;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

/**
 * Abstract BASE type of a result - it will be extended by the actual results of the providers
 * 
 * 
 *
 */
@Abstract
public interface AbstractAntivirusResult extends GenericEntity {

	EntityType<? extends AbstractAntivirusResult> T = EntityTypes.T(AbstractAntivirusResult.class);

	@Name("Resource Id")
	@Description("ID of the resource (optional)")
	@Unmodifiable
	<T> T getResourceId();
	void setResourceId(Object id);

	@Name("Resource Name")
	@Description("Resource name of resource (optional)")
	@Unmodifiable
	String getResourceName();
	void setResourceName(String resourceName);

	@Name("Infected")
	@Description("True if resource is infected")
	@Mandatory
	@Unmodifiable
	boolean getInfected();
	void setInfected(boolean infected);

	@Name("Message")
	@Description("Human readable message of the result")
	@Mandatory
	@Unmodifiable
	String getMessage();
	void setMessage(String message);

	@Name("Duration")
	@Description("Duration in ms")
	@Mandatory
	@Unmodifiable
	long getDurationInMs();
	void setDurationInMs(long durationInMs);
	
	default String details() {
		return null;
	}
}
