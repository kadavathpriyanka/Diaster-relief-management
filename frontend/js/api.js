export const API_BASE_URL = "http://localhost:8080/api";
export const HEALTH_URL = "http://localhost:8080/api/health";

export async function getHealth() {
  const controller = new AbortController();
  const timeout = window.setTimeout(() => controller.abort(), 5000);

  try {
    const response = await fetch(HEALTH_URL, {
      method: "GET",
      headers: { Accept: "application/json" },
      cache: "no-store",
      signal: controller.signal
    });

    if (!response.ok) throw new Error(`Health check failed (${response.status})`);

    const data = await response.json();
    if (!data || data.status !== "success") throw new Error("Unexpected health response");
    return data;
  } finally {
    window.clearTimeout(timeout);
  }
}
