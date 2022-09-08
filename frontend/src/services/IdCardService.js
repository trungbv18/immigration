import http from "@/http-common";

/* eslint-disable */
class IdCardService {
  getAll() {
    return http.get("/api/user");
  }
  getLastId() {
    return http.get("/api/identityCard/last-id");
  }
  create(data) {
    return http.post("/api/identityCard/save", data);
  }
}
export default new IdCardService();
