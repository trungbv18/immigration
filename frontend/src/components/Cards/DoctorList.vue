<template lang="">
<div class="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded" :class="[color === 'light' ? 'bg-white' : 'bg-emerald-900 text-white']">
  <Form id="customer_info" @submit="countPurposeFun" :validation-schema="valid_customer" class=" px-3">
    <div v-if="!successful">
      <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
        Statistic by type of purpose
      </h6>
      <div class="flex flex-wrap">
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              From
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="from_date" name="from_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="from_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              To
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="to_date" name="to_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="to_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              Purpose
            </label>
            <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="purpose" name="purpose">
              <option selected>Please select</option>
              <option v-for="item in purposeList" v-bind:key="item.id" v-bind:value="item.name">
                {{ item.name }}
              </option>
            </Field>
            <ErrorMessage name="purposes" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <p id="count_purpose" class="text-emerald-600 px-4"></p>
      </div>
      <div class="text-center py-6">
        <button :disabled="loading" class="w-full lg:w-3/12 bg-lightBlue-600 text-white active:bg-emerald-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="submit">
          <span v-show="loading" class="spinner-border spinner-border-sm">Processing</span>
          Submit
        </button>
      </div>
    </div>
  </Form>

  <Form id="customer_info" @submit="countIdCardFun" :validation-schema="valid_customer" class=" px-3">
    <div v-if="!successful">
      <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
        Statistic by type of ID card
      </h6>
      <div class="flex flex-wrap">
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              From
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="from_date" name="from_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="from_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              To
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="to_date" name="to_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="to_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              Type of ID card
            </label>
            <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="idcard" name="idcard">
              <option selected>Please select</option>
              <option v-for="item in idCardList" v-bind:key="item.id" v-bind:value="item.name">
                {{ item.name }}
              </option>
            </Field>
            <ErrorMessage name="idcard" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <p id="count_idcard" class="text-emerald-600 px-4"></p>
      </div>
      <div class="text-center py-6">
        <button :disabled="loading" class="w-full lg:w-3/12 bg-lightBlue-600 text-white active:bg-emerald-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="submit">
          <span v-show="loading" class="spinner-border spinner-border-sm">Processing</span>
          Submit
        </button>
      </div>
    </div>
  </Form>

  <Form id="customer_info" @submit="countLicenseFun" :validation-schema="valid_customer" class=" px-3">
    <div v-if="!successful">
      <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
        Statistic by type of License
      </h6>
      <div class="flex flex-wrap">
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              From
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="from_date" name="from_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="from_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              To
            </label>
            <Field style="height: 44px" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="to_date" name="to_date" type="date" min="1900-01-01" max="2025-12-31" />
            <!-- <Field type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="birthday" name="birthday" /> -->
            <ErrorMessage name="to_date" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <div class="w-full lg:w-4/12 px-4">
          <div class="relative w-full mb-3">
            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlFor="grid-password">
              Type of license
            </label>
            <Field as="select" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" required v-model="license" name="license">
              <option selected>Please select</option>
              <option v-for="item in licenseList" v-bind:key="item.id" v-bind:value="item.name">
                {{ item.name }}
              </option>
            </Field>
            <ErrorMessage name="license" class="text-red-500 text-sm italic" />
          </div>
        </div>
        <p id="count_license" class="text-emerald-600 px-4"></p>
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
</template>

<script>
//  import { ref } from "vue"
import {
  Form,
  Field,
  ErrorMessage
} from "vee-validate";
import PurposeService from "../../services/PurposeService";
import IdentificationInfo from "../../services/IdentificationInfo";
import LicenseTypeService from "../../services/LicenseTypeService";

import ImmigrationService from "../../services/ImmigrationService";

export default {
  data() {
    // const stats=ref([]);
    return {
      to_date: "",
      from_date: "",
      purposeList: "",
      idCardList: "",
      licenseList: "",
    }
  },
  methods: {
    getPurposes() {
      PurposeService.getAll()
        .then((response) => {
          this.purposeList = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getTypeOfIdCard() {
      IdentificationInfo.getAll()
        .then((response) => {
          this.idCardList = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getTypeOfLicense() {
      LicenseTypeService.getAll()
        .then((response) => {
          this.licenseList = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    countPurposeFun() {
      ImmigrationService.countPurposeByDay(this.purpose, this.from_date, this.to_date)
        .then((res) => {
          document.getElementById("count_purpose").innerHTML = "Tổng số lượt xuất nhập cảnh theo mục đích "+this.purpose+": "+res.data;
        })
    },
    countIdCardFun() {
      ImmigrationService.countIdCardByDay(this.idcard, this.from_date, this.to_date)
        .then((res) => {
          document.getElementById("count_idcard").innerHTML = "Tổng số lượt xuất nhập cảnh theo loại giấy tờ "+this.idcard+": "+res.data;
        })
    },
    countLicenseFun() {
      ImmigrationService.countLicenseByDay(this.license, this.from_date, this.to_date)
        .then((res) => {
          document.getElementById("count_license").innerHTML = "Tổng số lượt xuất nhập cảnh theo loại giấy phép "+this.license+": "+res.data;
        })
    }
    
  },
  props: {
    color: {
      default: "light",
      validator: function (value) {
        // The value must match one of these strings
        return ["light", "dark"].indexOf(value) !== -1;
      },
    },
  },
  mounted() {
    this.getPurposes();
    this.getTypeOfIdCard();
    this.getTypeOfLicense();
    
  },
  components: {

    Form,
    Field,
    ErrorMessage,
  },
}
</script>

<style lang="">
  
</style>
