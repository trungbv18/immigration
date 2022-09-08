<template>
<div>
  <navbar />
  <main class="profile-page">
    <section class="relative block h-500-px">
      <div class="absolute top-0 w-full h-full bg-center bg-cover" style="
            background-image: url('https://ychef.files.bbci.co.uk/976x549/p0bvnm3n.jpg');
          "></div>
      <div class="top-auto bottom-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden h-70-px" style="transform: translateZ(0)">
        <svg class="absolute bottom-0 overflow-hidden" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="none" version="1.1" viewBox="0 0 2560 100" x="0" y="0">
          <polygon class="text-blueGray-200 fill-current" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </section>
    <section class="relative py-16 bg-blueGray-200">
      <div class="container mx-auto px-4">
        <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64">
          <Form id="customer_info" @submit="submit" :validation-schema="valid_customer" class="px-3">
            <div v-if="!successful">
              <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
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
                      <option selected>Please select</option>
                      <option v-for="item in genders" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
                    </Field>
                    <ErrorMessage name="gender" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Date Of Birth
                    </label>
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" type="date" min="1900-01-01" max="2025-12-31" />
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

          <Form @submit="save" id="customer_license" :validation-schema="valid_license" class="hidden px-3">
            <div v-if="!successful">
              <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
                Identification Information
              </h6>
              <div class="flex flex-wrap">
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Identification Type
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="id_type" name="id_type">
                      <option selected>Please select</option>
                      <option v-for="item in idInfos" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
                    </Field>
                    <ErrorMessage name="id_type" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Identification Number
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="id_number" name="id_number" />
                    <ErrorMessage name="id_number" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Identification Date
                    </label>
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31" required v-model="id_date" name="id_date" />
                    <ErrorMessage name="id_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Identification Expiration Date
                    </label>
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31" required v-model="id_ex_date" name="id_ex_date" />
                    <ErrorMessage name="id_ex_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Identification Place
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="id_place" name="id_place" />
                    <ErrorMessage name="id_place" class="text-red-500 text-sm italic" />
                  </div>
                </div>
              </div>
              <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
                License Information
              </h6>
              <div class="flex flex-wrap">
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Type
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license_type" name="license_type">
                      <option selected>Please select</option>
                      <option v-for="item in licenseType" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
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
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31" required v-model="license_date" name="license_date" />
                    <ErrorMessage name="license_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      License Expiration Date
                    </label>
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" type="date" min="1900-01-01" max="2025-12-31" required v-model="license_ex_date" name="license_ex_date" />
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

          <Form id="customer_immigration" @submit="saveImmigration" :validation-schema="valid_immigration" class="hidden px-3">
            <div v-if="!successful">
              <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
                Immigration Information
              </h6>
              <div class="flex flex-wrap">
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Destination
                    </label>
                    <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="destination" name="destination" />
                    <ErrorMessage name="destination" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Purpose
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="purpose" name="purpose">
                      <option selected>Please select</option>
                      <option v-for="item in purposes" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
                    </Field>
                    <ErrorMessage name="purpose" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Start Date
                    </label>
                    <Field type="text" readonly class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" v-model="currentDateTime" name="date" />
                    <ErrorMessage name="date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Return Date
                    </label>
                    <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="return_date" name="return_date" type="date" min="1900-01-01" max="2025-12-31" />
                    <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
                    <ErrorMessage name="return_date" class="text-red-500 text-sm italic" />
                  </div>
                </div>
                <div class="w-full lg:w-6/12 px-4">
                  <div class="relative w-full mb-3">
                    <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
                      Dỉrection
                    </label>
                    <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="direction" name="direction">
                      <option selected>Please select</option>
                      <option v-for="item in directions" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
                    </Field>
                    <ErrorMessage name="direction" class="text-red-500 text-sm italic" />
                  </div>
                </div>
              </div>
              <div class="text-center py-6">
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
import LicenseService from "../services/LicenseService";
import IdentificationInfo from "../services/IdentificationInfo";
import IdCardService from "../services/IdCardService";
import PurposeService from "../services/PurposeService";
import DirectionService from "../services/DirectionService";
import ImmigrationService from "../services/ImmigrationService";

import swal from "sweetalert";
import {
  ref
} from "vue";

export default {
  data() {
    const licenseType = ref([]);
    const idInfos = ref([]);
    const purposes = ref([]);
    const directions = ref([]);
    const valid_customer = yup.object().shape({
      fullname: yup
        .string()
        .required("This field is required")
        .max(50, "Must be maximum 50 characters"),
      nationality: yup.string().required("This field is required"),
      gender: yup
        .number()
        .required("This field is required")
        .typeError("This field is required"),
      birthday: yup.string().required("This field is required"),
    });
    const valid_license = yup.object().shape({
      license_type: yup
        .number()
        .required("This field is required")
        .typeError("This field is required"),
      license_number: yup
        .number()
        .required("This field is required")
        .typeError("This field is required"),
      license_date: yup.string().required("This field is required"),
      license_ex_date: yup.string().required("This field is required"),
      license_place: yup.string().required("This field is required"),
      id_type: yup
        .number()
        .required("This field is required")
        .typeError("This field is required"),
      id_number: yup
        .number()
        .required("This field is required")
        .typeError("This field is required"),
      id_date: yup.string().required("This field is required"),
      id_ex_date: yup.string().required("This field is required"),
      id_place: yup.string().required("This field is required"),
    });
    return {
      genders: [{
          id: 1,
          name: "Male",
        },
        {
          id: 2,
          name: "Female",
        },
        {
          id: 3,
          name: "Other",
        },
      ],
      team2,
      valid_customer,
      valid_license,
      fullname: "",
      nationality: "",
      gender: "",
      birthday: "",
      license_type: "",
      license_number: "",
      license_date: "",
      license_ex_date: "",
      license_place: "",
      licenseType,
      purposes,
      directions,
      lastId: 0,
      lastIdFinal: "",
      lastIdLiFinal: "",
      lastIdLi: 0,
      lastIdCaFinal: "",
      lastIdCa: 0,
      idInfos,
      id_type: "",
      id_number: "",
      id_date: "",
      id_ex_date: "",
      id_place: "",
      destination:"",
      purpose:"",
      direction:"",
      return_date:"",
    };
  },
  methods: {
    submit() {
      let data = {
        fullname: this.fullname,
        nationality: this.nationality,
        gender: this.gender,
        dateOfBirth: this.birthday,
      };
      UserService.create(data)
        .then(() => {
          document.getElementById("customer_info").style.display = "none";
          document.getElementById("customer_license").style.display = "block";
          this.lastIdFinal = this.lastId + 1;
        })
        .catch(() => {
          swal("Error!", "Add Failed!", "error", {
            button: false,
            timer: 2000,
          });
        });
    },
    save() {
      let licenseData = {
        licenseNumber: this.license_number,
        issuedOn: this.license_date,
        dateOfExpiry: this.license_ex_date,
        placeOfIssue: this.license_place,
        typeOfLicenseByTypeId: {
          id: this.license_type,
        },
        usersByUserId: {
          id: this.lastIdFinal,
        },
      };
      let idData = {
        numberOfIdentitycard: this.id_number,
        placeOfIssue: this.id_place,
        dateOfExpiry: this.id_ex_date,
        typeofIdentitycardByTypeId: {
          id: this.id_type,
        },
        usersByUserId: {
          id: this.lastIdFinal,
        },
        //thieu ngay cap trong db
      };
      LicenseService.create(licenseData)
        .then(() => {
          IdCardService.create(idData);
        })
        .then(() => {
          document.getElementById("customer_license").style.display = "none";
          document.getElementById("customer_immigration").style.display = "block";
            "block";
          this.lastIdLiFinal = this.lastIdLi + 1;
          this.lastIdCaFinal = this.lastIdCa + 1;
        })
        .catch(() => {
          swal("Error!", "Add Failed!", "error", {
            button: false,
            timer: 2000,
          });
        });
    },
    
    saveImmigration() {
      let data = {
        destination: this.destination,
        returnDate: this.return_date,
        startDate: this.date,
        usersByUserId: { id: this.lastIdFinal },
        directionByDirectionId : { id: this.direction },
        purposeByPurposeId: { id: this.purpose},
        identitycardByIdentirycardId: { id : this.lastIdCaFinal },
        licenseByLicenseId: { id: this.lastIdLiFinal }
      }
      ImmigrationService.create(data)
      .then(() => {
          swal("Success!", "Add Successfully!", "success", {
            button: false,
            timer: 2000
          });
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
    },
    getLastIdLi() {
      LicenseService.getLastId()
        .then((response) => {
          this.lastIdLi = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getLastIdCa() {
      IdCardService.getLastId()
        .then((response) => {
          this.lastIdCa = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getIdentificationInfo() {
      IdentificationInfo.getAll()
        .then((response) => {
          this.idInfos = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getPurposes() {
      PurposeService.getAll()
        .then((response) => {
          this.purposes = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getDirections() {
      DirectionService.getAll()
        .then((response) => {
          this.directions = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.getLicenseType();
    this.getLastId();
    this.getIdentificationInfo();
    this.getPurposes();
    this.getDirections();
    this.getLastIdLi();
    this.getLastIdCa();
  },
  computed: {
    // a computed getter
    currentDateTime() {
      var today = new Date();
      var dd = today.getDate();
      var mm = today.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
      var yyyy = today.getFullYear();
      if (dd < 10) {
        dd = '0' + dd
      }
      if (mm < 10) {
        mm = '0' + mm
      }
      today = dd +'-'+mm+'-'+yyyy;
      return today;
      // console.log(date);
    },
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
