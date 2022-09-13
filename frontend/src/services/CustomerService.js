import http from "@/http-common";

/* eslint-disable */
class CustomerService {
  getAll() {
    return http.get("/api/customer");
  }

  getLastId() {
    return http.get("/api/user/last-id");
  }

  create(data) {
    return http.post("/api/customer", data);
  }
}
export default new CustomerService();
