import http from "@/http-common";

/* eslint-disable */
class LicenseTypeService {
  getAll() {
    return http.get("/api/typeOfLicense");
  }
}
export default new LicenseTypeService();
