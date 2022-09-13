import http from "@/http-common";

/* eslint-disable */
class BanService {
  getFromIdNum(number) {
    return http.get(`/api/ban/getFromIdNum/${number}`);
  }

  getLastId() {
    return http.get("/api/user/last-id");
  }

  create(data) {
    return http.post("/api/user/add", data);
  }
}
export default new BanService();
