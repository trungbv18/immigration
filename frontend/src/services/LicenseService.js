import http from "@/http-common";

/* eslint-disable */
class LicenseService {
  getAll() {
    return http.get("/api/license");
  }

  getLastId() {
    return http.get("/api/license/last-id");
  }

  create(data) {
    return http.post("/api/license", data);
  }

}
export default new LicenseService();
