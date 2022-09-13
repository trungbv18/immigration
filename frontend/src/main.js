import { createApp } from "vue";
import { createWebHistory, createRouter } from "vue-router";
import store from "./components/store";

// styles

import "@fortawesome/fontawesome-free/css/all.min.css";
import "@/assets/styles/tailwind.css";

// mouting point for the whole app

import App from "@/App.vue";

// layouts

import Admin from "@/layouts/Admin.vue";
import Auth from "@/layouts/Auth.vue";

// views for Admin layout

import Dashboard from "@/views/admin/Dashboard.vue";
import Settings from "@/views/admin/Settings.vue";
import Tables from "@/views/admin/Tables.vue";
import Specialist from "@/views/admin/Specialist.vue";
import DoctorList from "@/views/admin/Doctor.vue";
import MedicineList from "@/views/admin/Medicine.vue";
import Maps from "@/views/admin/Maps.vue";
import EditCarPage from "./components/Cards/EditCarPage.vue";
import EditSpecialist from "./components/Cards/EditSpecialist.vue";
import EditDoctorPage from "./components/Cards/EditDoctorPage.vue";
import EditMedicine from "./components/Cards/EditMedicine.vue";

// views for Auth layout

import Login from "@/views/auth/Login.vue";
import Register from "@/views/auth/Register.vue";

// views without layouts

import Landing from "@/views/Landing.vue";
import Profile from "@/views/Profile.vue";
import License from "@/views/Profile.vue";
import Index from "@/views/Index.vue";

// routes

const routes = [
  {
    path: "/admin",
    redirect: "/admin/doctor-manage",
    component: Admin,
    children: [
      {
        path: "/admin/dashboard",
        component: Dashboard,
      },
      {
        path: "/admin/settings",
        component: Settings,
      },
      {
        path: "/admin/facility-manage",
        component: Tables,
      },
      {
        path: "/admin/specialist-manage",
        component: Specialist,
      },
      {
        path: "/admin/doctor-manage",
        component: DoctorList,
      },
      {
        path: "/admin/medicine-manage",
        component: MedicineList,
      },
      {
        path: "/admin/car-edit/:id",
        component: EditCarPage,
      },  
      {
        path: "/admin/specialist-edit/:id",
        component: EditSpecialist,
      },
      {
        path: "/admin/doctor-edit/:id",
        component: EditDoctorPage,
      },
      {
        path: "/admin/medicine-edit/:id",
        component: EditMedicine,
      },
      {
        path: "/admin/maps",
        component: Maps,
      },
    ],
  },
  {
    path: "/auth",
    redirect: "/auth/login",
    component: Auth,
    children: [
      {
        path: "/auth/login",
        component: Login,
      },
      {
        path: "/auth/register",
        component: Register,
      },
    ],
  },
  {
    path: "/landing",
    component: Landing,
  },
  {
    path: "/add-info",
    component: Profile,
    meta: { requiresAuth: true },

  },
  {
    path: "/license",
    component: License,
  },
  {
    path: "/",
    redirect: "/admin/doctor-manage",
    component: Index,
  },
  { path: "/:pathMatch(.*)*", redirect: "/" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
router.beforeEach((to, from, next) => {
  // const publicPages = ['/booking-detail/:id','/login', '/register', '/' ,'/booking', '/auth/login'];
  // const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (to.meta.requiresAuth && !loggedIn) {
    next('/auth/login');
  } else {
    next();
  }
});

createApp(App).use(router).use(store).mount("#app");
