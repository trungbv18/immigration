import http from "@/http-common";

/* eslint-disable */
class UserService {
  getAll() {
    return http.get("/api/user");
  }

  getLastId() {
    return http.get("/api/user/last-id");
  }

  create(data) {
    return http.post("/api/user/add", data);
  }
}
export default new UserService();
