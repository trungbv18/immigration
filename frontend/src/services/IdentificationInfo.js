import http from "@/http-common";

/* eslint-disable */
class IdentificationInfo {
  getAll() {
    return http.get("/api/typeofIdentityCard/get-all");
  }

}
export default new IdentificationInfo();
