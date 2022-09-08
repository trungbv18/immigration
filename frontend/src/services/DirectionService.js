import http from "@/http-common";

/* eslint-disable */
class DirectionService {
  getAll() {
    return http.get("/api/direction");
  }
}
export default new DirectionService();
