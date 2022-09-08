import http from "@/http-common";

/* eslint-disable */
class PurposeService {
  getAll() {
    return http.get("/api/purposes");
  }
}
export default new PurposeService();
