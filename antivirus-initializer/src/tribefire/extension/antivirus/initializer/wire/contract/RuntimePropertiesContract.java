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
package tribefire.extension.antivirus.initializer.wire.contract;

import com.braintribe.wire.api.annotation.Default;

import tribefire.cortex.initializer.support.wire.contract.PropertyLookupContract;

public interface RuntimePropertiesContract extends PropertyLookupContract {

	DefaultAntivirusProvider ANTIVIRUS_DEFAULT_PROVIDER();

	//
	// ClamAV
	//
	@Default("clamav.clamav")
	String ANTIVIRUS_CLAMAV_URL();
	@Default("3310")
	int ANTIVIRUS_CLAMAV_PORT();
	@Default("20000")
	int ANTIVIRUS_CLAMAV_TIMEOUT();

	//
	// Cloudmersive
	//
	String ANTIVIRUS_CLOUD_MERSIVE_API_KEY();

	//
	// VirusTotal
	//
	String ANTIVIRUS_VIRUSTOTAL_API_KEY();
	@Default("2")
	int ANTIVIRUS_VIRUSTOTAL_POLL_INTERVAL();
	@Default("60")
	int ANTIVIRUS_VIRUSTOTAL_POLL_DURATION();

}
