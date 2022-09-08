import http from "@/http-common";

/* eslint-disable */
class ImmigrationService {
  getAll() {
    return http.get("/api/user");
  }
  getLastId() {
    return http.get("/api/identityCard/last-id");
  }
  create(data) {
    return http.post("/api/immigrationInformation", data);
  }
}
export default new ImmigrationService();
