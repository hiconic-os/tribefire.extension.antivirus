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
package tribefire.extension.antivirus.connector.api;

public final class AntivirusHealthCheckResult {

	public enum Status {
		ok,
		warn,
		fail
	}

	private final String name;
	private final Status status;
	private final String message;
	private final String details;

	public AntivirusHealthCheckResult(String name, Status status, String message, String details) {
		this.name = name;
		this.status = status;
		this.message = message;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public AntivirusHealthCheckResult withDetails(String details) {
		return new AntivirusHealthCheckResult(name, status, message, details);
	}

	public static AntivirusHealthCheckResult ok(String name, String message) {
		return new AntivirusHealthCheckResult(name, Status.ok, message, null);
	}

	public static AntivirusHealthCheckResult fail(String name, String message) {
		return new AntivirusHealthCheckResult(name, Status.fail, message, null);
	}
}
