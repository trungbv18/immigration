<template>
<div>
  <navbar />
  <main class="profile-page">
    <section class="relative block h-500-px">
      <div class="absolute top-0 w-full h-full bg-center bg-cover" style="
            background-image: url('https://images.unsplash.com/photo-1499336315816-097655dcfbda?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2710&q=80');
          ">
        <span id="blackOverlay" class="w-full h-full absolute opacity-50 bg-black"></span>
      </div>
      <div class="top-auto bottom-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden h-70-px" style="transform: translateZ(0);">
        <svg class="absolute bottom-0 overflow-hidden" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="none" version="1.1" viewBox="0 0 2560 100" x="0" y="0">
          <polygon class="text-blueGray-200 fill-current" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </section>
    <section class="relative py-16 bg-blueGray-200">
      <div class="container mx-auto px-4">
        <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64">
          <Form id="customer_info" @submit="submit" :validation-schema="schema" class="px-3">
            <div v-if="!successful">
              <h6 class="text-center text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                Customer Information
              </h6>
              <div class="flex flex-wrap">
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Full Name
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="fullname" name="fullname" />
                    <ErrorMessage name="fullname" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Gender
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="gender" name="gender">
                      <option v-for="item in genders" v-bind:key="item.id" v-bind:value="item.id"> {{ item.name }} </option>
                    </Field>
                    <ErrorMessage name="gender" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Date Of Birth
                    </label>
                    <Field style="height:44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" type="date" min="1900-01-01" max="2025-12-31" />
                    <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
                    <ErrorMessage name="birthday" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Nationality
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="nationality" name="nationality" />
                    <ErrorMessage name="nationality" class="text-red-500 text-sm italic" />
                  </div>
                </div>

              </div>

              <div class="text-center py-6">
                <!-- <a href="/admin/car-manage" class="text-center w-full lg:w-3/12  bg-red-500 text-white active:bg-red-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="button">
                  Back
                </a> -->
                <button :disabled="loading" class="w-full lg:w-3/12 bg-lightBlue-600 text-white active:bg-emerald-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="submit">
                  <span v-show="loading" class="spinner-border spinner-border-sm">Processing</span>
                  Submit
                </button>
              </div>
            </div>
          </Form>

          <Form id="customer_license" :validation-schema="schema" class=" px-3">
            <div v-if="!successful">
              <h6 class="text-center text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                License Information
              </h6>
              <div class="flex flex-wrap">
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <!-- <label  class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Type
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license_type" name="license_type">
                    <option v-for="item in licenseType" v-bind:key="item.id" v-bind:value="item.id"> {{ item.name }} </option>
                    </Field>
                    <ErrorMessage name="license_type" class="text-red-500 text-sm italic" /> -->
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Type
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license_type" name="license_type">
                      <option v-for="item in licenseType" v-bind:key="item.id" v-bind:value="item.id"> {{ item.name }} </option>
                    </Field>
                    <ErrorMessage name="license_type" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Number
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license_number" name="license_number" />
                    <ErrorMessage name="license_number" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Date
                    </label>
                    <Field style="height:44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31"  required v-model="license_date" name="license_date" />
                    <ErrorMessage name="license_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Expiration Date
                    </label>
                    <Field style="height:44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31" required v-model="license_ex_date" name="license_ex_date" />
                    <ErrorMessage name="license_ex_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Place
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license_place" name="license_place" />
                    <ErrorMessage name="license_place" class="text-red-500 text-sm italic" />
                  </div>
                </div>

              </div>

              <div class="text-center py-6">
                <!-- <a href="/admin/car-manage" class="text-center w-full lg:w-3/12  bg-red-500 text-white active:bg-red-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="button">
                  Back
                </a> -->
                <button :disabled="loading" class="w-full lg:w-3/12 bg-lightBlue-600 text-white active:bg-emerald-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="submit">
                  <span v-show="loading" class="spinner-border spinner-border-sm">Processing</span>
                  Submit
                </button>
              </div>
            </div>
          </Form>
        </div>
      </div>
    </section>
  </main>
  <footer-component />
</div>
</template>

<script>
import Navbar from "@/components/Navbars/AuthNavbar.vue";
import FooterComponent from "@/components/Footers/Footer.vue";
import {
  Form,
  Field,
  ErrorMessage
} from "vee-validate";
import * as yup from "yup";
import team2 from "@/assets/img/team-2-800x800.jpg";
import UserService from "../services/UserService";
import LicenseTypeService from "../services/LicenseTypeService";
import swal from 'sweetalert';
import { ref } from "vue"

export default {
  data() {
    const licenseType=ref([])
    const schema = yup.object().shape({
      fullname: yup
        .string()
        .required("This field is required")
        .max(50, "Must be maximum 50 characters"),
      nationality: yup
        .string()
        .required("This field is required"),
      gender: yup
        .number()
        .required("This field is required")
        .typeError('This field is required'),
      birthday: yup
        .string()
        .required("This field is required")
    });
    return {
      genders: [{
          id: 1,
          name: 'Male'
        },
        {
          id: 2,
          name: 'Female'
        },
        {
          id: 3,
          name: 'Other'
        },

      ],
      team2,
      schema,
      fullname: "",
      nationality: "",
      gender: "",
      birthday: "",
      license_type:"",
      license_number: "",
      license_date:"",
      license_ex_date:"",
      license_place:"",
      licenseType,
      lastId:""
    };
  },
  methods: {
    submit() {
      let data = {
        fullname: this.fullname,
        nationality: this.nationality,
        gender: this.gender,
        dateOfBirth: this.birthday
      }
      UserService.create(data)
        .then(() => {
          document.getElementById('customer_info').style.display = "none";
          document.getElementById('customer_license').style.display = "block";
        })
        .catch(() => {
          swal("Error!", "Add Failed!", "error", {
            button: false,
            timer: 2000
          });
        });
    },
    getLicenseType() {
      LicenseTypeService.getAll()
        .then((response) => {
          this.licenseType = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getLastId() {
      UserService.getLastId()
      .then((response) => {
          this.lastId = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.getLicenseType();
    this.getLastId();
  },
  components: {
    Navbar,
    FooterComponent,
    Form,
    Field,
    ErrorMessage,
  },
};
</script>
