<template>
  <div class="flex flex-col md:flex-row h-screen w-screen m-sm:flex-column">
    <section class="md:w-1/2" style='background-image: linear-gradient(to right, #F15922 , #f17822)'>
      <div class="flex flex-col items-center md:mt-0 sm:max-w-xl xl:p-0 text-left justify-center text-white
       mx-auto md:h-screen  lg:py-0">
        <div>
          <h3 class="text-2xl font-bold text-left mb-7">FLORIJN</h3>
          <h1 class="text-5xl font-semibold mb-5">Dankuwel voor het kiezen van Florijn!</h1>
        </div>
        <div>
          <p class="text-md font-light">Wij van Florijn zijn erg blij met u als nieuwe gebruiker. We weten zeker dat we
            u niet zullen teleurstellen.</p>
          <img :src="require('@/assets/img/undraw_hello_re_3evm.svg')"
               class="mb-6 justify-center m-auto"
               style="max-height: 400px">
          <p class="text-md font-medium mb-3">Als u al een account hebt, hoeft u zich niet aan te melden.</p>
          <button @click="this.$router.push('/login')" type="submit"
                  class="w-full rounded-lg font-medium bg-white px-4 py-1.5 text-black"> Inloggen
          </button>
          <br>
          <br>
        </div>
      </div>
    </section>

    <section class="md:w-1/2 m-2">
      <div class="flex flex-col items-center justify-center mx-auto md:h-screen lg:py-0">
        <div class="w-full text-left  text-black bg-white rounded-lg md:mt-0 sm:max-w-xl xl:p-0">
          <a href="#" class="flex text-left items-center mb-3 text-3xl font-semibold text-gray-900 dark:text-white">
            Welkom bij Florijn
          </a>
          <h1 class="text-2xl font-semibold">
            Stap {{ this.step + 1 }}/4
          </h1>
          <div class="mt-3 space-y-5">
            <form class="text-left space-y-4 md:space-y-6" action="#">
              <div v-if="this.step === 0">
                <div class="mb-5">
                  <div>
                    <label for="email" class="block text-left text-md font-medium text-gray-900 dark:text-white">Uw
                      E-mail</label>
                    <p v-if="!checkEmail()" class="text-gray-500 text-sm">Vul een geldig e-mailadres in</p>
                    <p v-else-if="checkEmail()" class="text-gray-500 text-sm"></p>
                    <input @change="checkEmailAndPassword()" v-model="this.email" type="email" name="email" id="email"
                           class="bg-gray-50 border border-gray-300 text-gray-900
                sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5
                dark:focus:border-blue-500" placeholder="name@company.com" required="">
                  </div>
                </div>

                <div class="text-left mb-3">
                  <h1 class="text-md font-medium">
                    Wachtwoord voorwaarden:
                  </h1>
                  <p class="text-sm font-normal text-gray-500">
                    - Het wachtwoord moet minstens 14 tekens lang zijn.
                  </p>
                  <p class="text-sm font-normal text-gray-500">
                    - Het wachtwoord moet ten minste één hoofdletter (A-Z).
                  </p>
                  <p class="text-sm font-normal text-gray-500">
                    - Minstens één kleine letter (a-z)
                  </p>
                  <p class="text-sm font-normal text-gray-500">
                    - Minstens één cijfer (0-9)
                  </p>
                  <p class="text-sm font-normal text-gray-500">
                    - Minstens één speciaal teken (niet-woordelijk teken) bevatten.
                  </p>
                </div>

                <div class="grid md:grid-cols-2 md:gap-4">

                  <div>
                    <label for="password"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wachtwoord</label>
                    <input @change="checkEmailAndPassword()" v-model="this.password" type="password" name="password"
                           id="password" placeholder="••••••••"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           required="">
                  </div>
                  <div>
                    <label for="password"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Herhaal
                      wachtwoord</label>
                    <input @change="checkEmailAndPassword()" v-model="this.repeatPassword" type="password"
                           name="password"
                           id="password" placeholder="••••••••"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           required="">
                  </div>

                </div>

                <div class="mt-3">

                  <div class="flex flex-row justify-between">
                    <h1 class="font-medium text-sm text-gray-900">Wachtwoord sterkte</h1>
                    <div>
                      <h1 class="text-red-500 font-semibold" v-if="this.passwordStrength === 1">Zwak</h1>
                      <h1 class="text-yellow-500 font-semibold" v-else-if="this.passwordStrength === 2">Gemiddeld</h1>
                      <h1 class="text-green-500 font-semibold" v-else-if="this.passwordStrength === 3">Sterk</h1>
                    </div>
                  </div>
                  <div class="w-full bg-gray-100 rounded-full mt-2 border border-1 border-gray-300 dark:bg-gray-700">
                    <div v-if="this.passwordStrength === 0"
                         class="bg-red-500 text-xs font-medium text-center p-2 leading-none rounded-l-full"
                         style="width: 0"></div>
                    <div v-else-if="this.passwordStrength === 1"
                         class="bg-red-500 text-xs font-medium text-center p-2 leading-none rounded-l-full"
                         style="width: 33%"></div>
                    <div v-else-if="this.passwordStrength === 2"
                         class="bg-yellow-500 text-xs font-medium text-center p-2 leading-none rounded-l-full"
                         style="width: 66%"></div>
                    <div v-else-if="this.passwordStrength === 3"
                         class="bg-green-500 text-xs font-medium text-center p-2 leading-none rounded-full"
                         style="width: 100%"></div>
                  </div>
                  <div class="text-left">
                    <p v-if="this.passwordStrength === 0" class="text-md font-normal text-gray-500 pb-3">U heeft uw
                      wachtwoord nog niet ingevuld.</p>
                    <p v-else-if="this.passwordStrength === 1" class="text-md font-normal text-gray-500 pb-3">Kom op!
                      U kan wel een beter wachtwoord verzinnen.</p>
                    <p v-else-if="this.passwordStrength === 2" class="text-md font-normal text-gray-500 pb-3">Uw
                      wachtwoord kan wel sterker dan dit hoor.</p>
                    <p v-else-if="this.passwordStrength === 3" class="text-md font-normal text-gray-500 pb-3">Wauw!
                      Wat een sterk wachtwoord!</p>
                  </div>
                </div>
              </div>

              <div v-else-if="this.step===1">
                <div class="grid grid-cols-3 md:gap-4">
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Voornaam</label>
                    <input @change="checkUserInfo()" v-model="this.first_name" type="text" name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="John" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                      (optioneel)
                    </label>
                    <input @change="checkUserInfo()" v-model="this.second_name" type="text" name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="van" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_last_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                    <input @change="checkUserInfo()" v-model="this.last_name" type="text" name="floating_last_name"
                           id="floating_last_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="Doe" required/>
                  </div>
                </div>

                <div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Telefoonnummer</label>
                    <input type="text"
                           @change="checkUserInfo()" v-model="this.phone"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="+31 6 12345678" required/>
                  </div>
                </div>

                <div class="grid md:grid-cols-3 md:gap-4">
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Adres</label>
                    <input type="text"
                           @change="checkUserInfo()" v-model="this.address"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="Wibautstraat 1" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Postcode</label>
                    <input type="text"
                           @change="checkUserInfo()" v-model="this.zip_code"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="1234 AB" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Plaatsnaam</label>
                    <input @change="checkUserInfo()" v-model="this.city"
                           type="text"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 "
                           placeholder="Amsterdam" required/>
                  </div>
                </div>

                <div class="flex items-center justify-between grid md:grid-cols-2 md:gap-4">
                  <div>
                    <label for="countries"
                           class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Accounttype</label>
                    <select @change="checkUserInfo(); assignType($event);" v-model="this.accountType" id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                      <option selected>Kies een accounttype</option>
                      <option value=1>Client</option>
                      <option value=2>Specialist</option>
                    </select>
                  </div>
                  <div>
                    <label for="countries"
                           class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Geslacht</label>
                    <select @change="checkUserInfo(); assignGender($event);" v-model="this.gender" id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                      <option selected>Kies een geslacht</option>
                      <option value=1>Man</option>
                      <option value=2>Vrouw</option>
                      <option value=3>Zeg ik liever niet</option>
                      <option value=4>Anders</option>
                    </select>
                  </div>
                </div>
              </div>

              <div v-else-if="this.step===2">
                <form class="text-left h-fit pt-3">
                  <div class="mb-3">
                    <label class="block mb-2 text-sm font-medium text-gray-900" for="file_input">Upload
                      Profielfoto</label>
                    <input
                        class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
                        aria-describedby="file_input_help" id="file_input" type="file">
                    <p class="mt-1 text-sm text-gray-500 dark:text-gray-300" id="file_input_help">SVG, PNG of JPG</p>
                  </div>

                  <div v-if="this.accountType === 2">

                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Functie
                      titel</label>
                    <input type="text" v-model="this.title"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 mb-2 block w-full p-2.5 "
                           placeholder="Software Engineer" required/>

                  </div>

                  <div>
                    <label for="countries"
                           class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Beschikbaar</label>
                    <select @change="assignAvailable($event);" v-model="this.available" id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                      <option selected>Bent u per direct beschikbaar?</option>
                      <option value=1>Ja</option>
                      <option value=0>Nee</option>
                    </select>
                  </div>

                  <div class="mb-4">
                    <label for="description"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Bio</label>
                    <textarea v-model="this.bio" id="description" rows="4"
                              class="block p-2.5 w-full h-24 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-orange-500 focus:border-orange-500"
                              placeholder="Schrijf hier iets over uzelf beschrijving..."
                    ></textarea>
                  </div>
                </form>
              </div>

              <div v-else>
                <div>
                  <img class="w-48 h-48 rounded-lg p-2" :src="require('@/assets/img/undraw_add_to_cart_re_wrdo-2.svg')">
                </div>
                <div>
                  <h1 class="text-2xl font-medium">{{
                      this.first_name + " " + this.second_name + " " + this.last_name
                    }}</h1>
                  <h1 class="text-xl font-normal" v-if="this.accountType==='2'">{{ this.title }}</h1>
                  <h1 class="text-lg font-normal"><i class="text-gray-400 fa-solid fa-envelope fa-sm"></i> {{
                      this.email
                    }}</h1>
                  <h1 class="text-lg font-normal"><i class="text-gray-400 fa-solid fa-phone fa-sm "></i> {{
                      this.phone
                    }}</h1>
                  <h1 class="text-lg font-normal"><i class="text-gray-400 fa-solid fa-location-dot fa-sm"></i>
                    {{ this.address + " " + this.zip_code + " " + this.city }}</h1>
                  <h1 class="text-lg font-medium mt-2">Bio</h1>
                  <h1 class="text-lg font-normal">{{ this.bio }}</h1>
                </div>
              </div>

            </form>

            <div class="grid grid-cols-2 md:gap-4">

              <div>
                <button v-if="checkEmailAndPassword() && this.step > 0" @click="this.step--"
                        class='transition-all w-full rounded-lg font-medium bg-gray-500 hover:bg-gray-600 px-4 py-1.5 text-white'
                >Vorige stap
                </button>
              </div>

              <div>
                <button v-if="checkEmailAndPassword() && this.step===0" @click="this.step++"
                        class="transition-all w-full rounded-lg font-medium bg-orange-500 hover:bg-orange-600 px-4 py-1.5 text-white"
                >Volgende stap
                </button>
                <button v-else-if="checkUserInfo() && this.step===1" @click="this.step++"
                        class="transition-all w-full rounded-lg font-medium bg-orange-500 hover:bg-orange-600 px-4 py-1.5 text-white"
                >Volgende stap
                </button>

                <button v-else-if="this.step===2 && this.bio!==null" @click="step++"
                        class="transition-all w-full rounded-lg font-medium bg-orange-500 hover:bg-orange-600 px-4 py-1.5 text-white"
                >Bekijk overzicht
                </button>

                <button v-else-if="this.step===2 && this.bio===null" @click="step++"
                        class="transition-all cursor-not-allowed w-full rounded-lg font-medium bg-orange-200 px-4 py-1.5 text-white"
                        disabled
                >Bekijk overzicht
                </button>

                <button v-else-if="this.step===3" @click="registerRequest()"
                        class="transition-all w-full rounded-lg font-medium bg-orange-500 hover:bg-orange-600 px-4 py-1.5 text-white"
                >Account opslaan
                </button>

                <button v-else-if="this.step===4" disabled type="button"
                        class="w-full rounded-lg font-medium bg-orange-200 px-4 py-1.5 text-white">
                  <svg class="inline mr-2 w-6 h-6 text-gray-200 animate-spin dark:text-gray-600" viewBox="0 0 100 101"
                       fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z"
                        fill="currentColor"/>
                    <path
                        d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z"
                        fill="#F15922"/>
                  </svg>
                  Account wordt opgeslagen
                </button>

                <button v-else
                        class="transition-all cursor-not-allowed w-full rounded-lg font-medium bg-orange-200 px-4 py-1.5 text-white"
                        disabled
                >Volgende stap
                </button>
              </div>

            </div>

          </div>
        </div>
      </div>
    </section>

  </div>

</template>

<script>
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "RegisterPage",

  data() {
    return {
      email: null,
      password: null,
      bio: null,
      title: null,
      available: null,
      repeatPassword: null,
      first_name: null,
      second_name: null,
      preposition: null,
      last_name: null,
      address: null,
      zip_code: null,
      city: null,
      phone: null,
      accountType: null,
      gender: null,

      toast: useToast(),

      step: 0,
      buttonType: 0,
      passwordStrength: 0
    }
  },

  methods: {
    async registerRequest() {

      let request = await axios.post(process.env.VUE_APP_API_URL + "/api/users/register", {
        email: this.email,
        password: this.password,
        first_name: this.first_name,
        second_name: this.preposition,
        address: this.address,
        zipCode: this.zip_code,
        city: this.city,
        bio: this.bio,
        last_name: this.last_name,
        phone: this.phone,
        userType: parseInt(this.accountType)
      }).catch((err) => {
        this.toast.error("Er ging wat mis, probeer het later nog eens :(")
      })

      this.step = 3

      if (request.status === 200) {
        let response = request.data
        let userType = response.userType
        localStorage.setItem("id", response.id)
        localStorage.setItem("userType", response.userType)

        if (userType === 0) {
          this.$router.push("/admin").then(() => {
            this.$router.go()
          })
        }
        if (userType === 1) {

          this.$router.push("/client/dashboard").then(() => {
            this.$router.go().then(() => {
              this.$router.go()
            })
          })
        }

        if (userType === 2) {

          this.$router.push("/notfound").then(() => {
            this.$router.go()
          })
        }
        // location.reload()
      }
    },

    nextStep() {
      this.step++
    },

    checkEmailAndPassword() {
      const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
      const strongRegex = new RegExp("^(?=.{14,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
      const mediumRegex = new RegExp("^(?=.{10,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
      const enoughRegex = new RegExp("^(?=.{8,}).*", "g");

      if (this.password === null) {
        this.passwordStrength = 0
      } else if (false === enoughRegex.test(this.password)) {
        this.passwordStrength = 1
      } else if (strongRegex.test(this.password)) {
        this.passwordStrength = 3
      } else if (mediumRegex.test(this.password)) {
        this.passwordStrength = 2
      }

      if (this.password === this.repeatPassword && this.passwordStrength === 3 && emailRegex.test(this.email)) {
        this.buttonType = 1;
        return true;
      }
    },

    checkEmail() {
      const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

      if (emailRegex.test(this.email)) {
        return true;
      }
    },

    checkUserInfo() {
      return this.first_name !== null && this.second_name !== null && this.last_name !== null
          && this.address !== null && this.zip_code !== null && this.city !== null && this.phone !== null
          && this.accountType !== null && this.gender !== null;
    },

    assignGender(event) {
      this.gender = event.target.value;
    },

    assignType(event) {
      this.accountType = event.target.value;
    },

    assignAvailable(event) {
      this.available = event.target.value;
    }
  }
}
</script>

<style scoped>

</style>