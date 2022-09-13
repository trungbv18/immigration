<template lang="">
<div class="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded" :class="[color === 'light' ? 'bg-white' : 'bg-emerald-900 text-white']">
  <Form id="customer_info" @submit="submit" :validation-schema="valid_customer" class=" px-3">
            <div v-if="!successful">
              <h6 class="text-center text-emerald-600 text-sm mt-3 mb-6 font-bold uppercase">
                Statistic
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
                      <option v-for="item in purposes" v-bind:key="item.id" v-bind:value="item.id">
                        {{ item.name }}
                      </option>
                    </Field>
                    <ErrorMessage name="purposes" class="text-red-500 text-sm italic" />
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
</template>

<script>
//  import { ref } from "vue"
import {
  Form,
  Field,
  ErrorMessage
} from "vee-validate";
import PurposeService from "../../services/PurposeService";

export default {
  data() {
    // const stats=ref([]);
    return {
      to_date:"",
      from_date:"",
      stats: [{
          id: 1,
          name: "quốc tịch"
        },
        {
          id: 2,
          name: "mục đích"
        }

      ]

    }
  },
  methods: {
    getPurposes() {
      PurposeService.getAll()
        .then((response) => {
          this.purposes = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
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
