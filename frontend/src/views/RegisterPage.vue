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
          <a class="flex text-left items-center mb-3 text-3xl font-semibold text-gray-900 dark:text-white">
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
                    <input @change="this.checkEmailExists(this.email)" v-model="this.email" type="email" name="email"
                           id="email"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5 focus:ring-gray-500 focus:border-gray-500"
                           :class="this.emailExists && 'border border-red-400 focus:ring-red-500 focus:border-red-500'"
                           placeholder="name@company.com" required="">
                    <p v-if="this.emailExists" class="text-red-500 text-sm">
                      Dit e-mailadres is al in gebruik, vul een ander e-mailadres in of <a
                        @click="this.$router.push('/login')" class="underline pointer-cursor">log in</a>
                    </p>
                    <p v-else></p>
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
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           required="">
                  </div>
                  <div>
                    <label for="password"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Herhaal
                      wachtwoord</label>
                    <input @change="checkEmailAndPassword()" v-model="this.repeatPassword" type="password"
                           name="password"
                           id="password" placeholder="••••••••"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
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
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           placeholder="John" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Tussenvoegsel
                      (optioneel)
                    </label>
                    <input @change="checkUserInfo()" v-model="this.second_name" type="text" name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           placeholder="van" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_last_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Achternaam</label>
                    <input @change="checkUserInfo()" v-model="this.last_name" type="text" name="floating_last_name"
                           id="floating_last_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
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
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
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
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           placeholder="Wibautstraat 1" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Postcode</label>
                    <input type="text"
                           @change="checkUserInfo()" v-model="this.zip_code"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           placeholder="1234 AB" required/>
                  </div>
                  <div class="relative z-0 mb-6 w-full group">
                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Plaatsnaam</label>
                    <input @change="checkUserInfo()" v-model="this.city"
                           type="text"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 "
                           placeholder="Amsterdam" required/>
                  </div>
                </div>

                <div class="flex items-center justify-between grid md:grid-cols-2 md:gap-4">
                  <div>
                    <label for="countries"
                           class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Accounttype</label>
                    <select @change="checkUserInfo(); assignType($event);" v-model="this.accountType" id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                      <option selected>Kies een accounttype</option>
                      <option value=1>Client</option>
                      <option value=2>Specialist</option>
                    </select>
                  </div>
                  <div>
                    <label for="countries"
                           class="block mb-2 text-left text-sm font-medium text-gray-900 dark:text-gray-400">Geslacht</label>
                    <select @change="checkUserInfo(); assignGender($event);" v-model="this.gender" id="countries"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
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

                  <div v-if="this.accountType == 2">

                    <form>
                      <label class="block mb-2 text-sm font-medium text-gray-900">Upload CV</label>
                      <input
                          class="block w-full text-sm mb-2 text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50"
                          id="file_input"
                          type="file"
                          v-on:change="handleFileInputChange"/>
                    </form>

                    <label for="floating_first_name"
                           class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">Wat voor
                      specialist bent u?</label>
                    <input type="text" v-model="this.specialistType"
                           name="floating_first_name"
                           id="floating_first_name"
                           class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-gray-500 focus:border-gray-500 mb-2 block w-full p-2.5 "
                           placeholder="Software Engineer, Backend Engineer, Web Developer etc." required/>

                    <div class="mb-2">
                      <label for="search"
                             class="block text-left mb-2 text-sm font-medium text-gray-900 dark:text-white">
                        Voeg Skills toe
                      </label>
                      <input type="text" id="search" placeholder="Zoek hier de skills" v-model="searchTerm"
                             class="w-full bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-orange-500 focus:border-orange-500">
                      <ul v-if="searchSkills.length"
                          class="w-1/4 rounded-lg bg-white border border-gray-300 px-4 text-left py-2 space-y-1 absolute z-10">
                        <li v-for="skill in searchSkills" :key="skill.name" @click="selectSkill(skill), addSkill(skill)"
                            class="cursor-pointer hover:bg-orange-100 p-1">
                          {{ skill.name }}
                        </li>
                      </ul>
                      <div id="selectedCountries" class="text-left grid grid-cols-2 space-x-2"
                           v-for="skill in this.projectSkills" :key="skill.id">
                        <div>
                          <div class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
                            Skill:
                          </div>
                          <div @click="deleteCountry(skill)"
                               class="cursor-pointer bg-gray-100 border border-gray-300 text-sm px-2 w-full h-auto py-1 m-auto rounded-lg">
                            <div class="flex items-center space-x-1"><span>{{ skill.name }}</span>
                              <i class="fa-solid fa-xmark"></i>
                            </div>
                          </div>
                        </div>

                        <div>
                          <label for="countries" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Selecteer
                            uw niveau</label>
                          <select @change="addLevel($event)" id="countries"
                                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                            <option selected>Hoe goed u in deze skill</option>
                            <option value=1>Beginner</option>
                            <option value=2>Gevorderd</option>
                            <option value=3>Competent</option>
                            <option value=4>Bedreven</option>
                            <option value=5>Expert</option>
                          </select>
                        </div>
                      </div>
                    </div>

                  </div>

                  <div class="mb-4">
                    <label for="description"
                           class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Bio</label>
                    <textarea v-model="this.bio" id="description" rows="4"
                              class="block p-2.5 w-full h-24 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-gray-500 focus:border-gray-500"
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

                  <div v-if="this.accountType == 2">

                    <h1 class="text-lg font-medium mt-2">Skills</h1>
                    <div id="selectedCountries" class="text-left grid grid-cols-2 space-x-2"
                         v-for="skill in this.projectSkills" :key="skill.id">
                      <div>
                        <div
                            class="cursor-pointer bg-gray-100 border border-gray-300 text-sm px-2 w-full h-auto py-1 m-auto rounded-lg">
                          <div class="flex items-center space-x-1"><span>{{ skill.name }}</span></div>
                        </div>
                      </div>
                    </div>

                    <h1 class="text-lg font-medium mt-2">Soort specialist</h1>
                    <h1 class="text-lg font-normal"> {{
                        this.specialistType
                      }}</h1>
                  </div>
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

                <button
                    v-else-if="this.step===2 && this.bio===null && this.accountType==2 && this.specialistType && this.projectSkills.length!==0"
                    @click="step++"
                    class="transition-all cursor-not-allowed w-full rounded-lg font-medium bg-orange-200 px-4 py-1.5 text-white"
                    disabled
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
import {computed, ref} from "vue";

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
      emailExists: false,
      skills: [],
      projectSkills: [],
      specialistType: "",
      skillLevels: [],
      selectedLevel: 0,
      website: "",
      fileId: '',
      file: null,

      toast: useToast(),

      step: 0,
      buttonType: 0,
      passwordStrength: 0
    }
  },

  methods: {
    addSkill(skill) {
      this.projectSkills.push(skill)
    },

    async checkEmailExists(email) {
      try {
        const response = await axios.get(process.env.VUE_APP_API_URL + `/api/users/check-email/${email}`);
        if (response.status === 400) {
          this.emailExists = true;
          console.log("ja man")
        } else {
          this.emailExists = false;
          console.log("nee man")
        }
      } catch (err) {
        if (err.response.status === 400) {
          this.emailExists = true;
          console.log("ja man")
        } else {
          console.log(err);
        }
      }
    },

    async registerRequest() {
      // Create the base user data object
      let userData = {
        email: this.email,
        password: this.password,
        first_name: this.first_name,
        second_name: this.preposition,
        last_name: this.last_name,
        address: this.address,
        zipCode: this.zip_code,
        city: this.city,
        bio: this.bio,
        phone: this.phone,
        userType: parseInt(this.accountType)
      }

      // If the user is a specialist, add specialist data to the object
      if (this.accountType == 2) {
        userData.specialist = {
          available: 1,
          specialistType: this.specialistType,
          approvalStatus: 2,
        }
      }

      try {
        // Attempt to register the user
        await fetch(process.env.VUE_APP_API_URL + `/api/users/register`, {
          method: 'POST',
          body: JSON.stringify(userData),
          headers: {
            "Content-Type": "application/json"
          }
        }).then( response => {
          if (response.ok){
            return response.json();

          }
          }).then(async data => {

            localStorage.setItem("id", data.id)
            localStorage.setItem("userType", data.userType)
            // Display success message
            this.toast.success("Uw account is aangemaakt", {
              position: "bottom-center",
              timeout: 4000,
              closeOnClick: true,
              pauseOnFocusLoss: true,
              pauseOnHover: true,
              draggable: true,
              draggablePercent: 0.6,
              showCloseButtonOnHover: false,
              hideProgressBar: true,
              closeButton: "button",
              icon: true,
              rtl: false
            })
            console.log(data)


            // If the user is a specialist, add skills to their specialist profile and the CV
            if (this.accountType == 2) {
              await this.uploadSkills(data.id);
              await this.uploadFile(data.id);
              // Navigate to specialist page
              this.$router.push("/specialist/pending").then(() => {
                this.$router.go()
              })
            }

            // If the user is a client, navigate to their dashboard
            if (this.accountType == 1) {
              this.$router.push("/client/dashboard").then(() => {
                this.$router.go().then(() => {
                  this.$router.go()
                })
              })
            }
            this.step = 3
          }).catch(err => {
            console.error(err);
          })

        } catch (err) {
        // Display error message if registration fails
        console.log(err)
        this.toast.error("Er ging wat mis met het aanmaken van uw account", {
          position: "bottom-center",
          timeout: 4000,
          closeOnClick: true,
          pauseOnFocusLoss: true,
          pauseOnHover: true,
          draggable: true,
          draggablePercent: 0.6,
          showCloseButtonOnHover: false,
          hideProgressBar: true,
          closeButton: "button",
          icon: true,
          rtl: false
        })
      }
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

      if (this.password === this.repeatPassword && this.passwordStrength === 3 && emailRegex.test(this.email) && !this.emailExists) {
        this.buttonType = 1;
        return true;
      }
    }
    ,

    checkEmail() {
      const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

      if (emailRegex.test(this.email)) {
        return true;
      }
    }
    ,

    checkUserInfo() {
      return this.first_name !== null && this.last_name !== null
          && this.address !== null && this.zip_code !== null && this.city !== null && this.phone !== null
          && this.accountType !== null && this.gender !== null;
    }
    ,

    assignGender(event) {
      this.gender = event.target.value;
    }
    ,

    assignType(event) {
      this.accountType = event.target.value;
      console.log(this.accountType)
    }
    ,

    assignAvailable(event) {
      this.available = event.target.value;
    }
    ,

    addLevel(event) {
      this.skillLevels.push(Number(event.target.value));
      console.log(this.skillLevels)
      console.log(this.projectSkills)
    },

    async uploadSkills(id) {
      for (let i = 0; i < this.projectSkills.length; i++) {
        await axios.post(process.env.VUE_APP_API_URL + `/api/users/specialist/${id}/skill`, {
          skill: this.projectSkills[i],
          level: this.skillLevels[i],
          specialist_id: id
        })
      }
    },

    handleFileInputChange(event) {
      this.file = event.target.files[0];
    },

    async uploadFile(id) {
      // Log the value of this.file to the console
      console.log(this.file)

      // Create a new FormData object to hold the file
      const data = new FormData();
      // Append the file to the FormData object
      data.append("file", this.file);

      // Log the FormData object to the console
      console.log(data)

      // Send a POST request to the server with the file data
      await fetch(`${process.env.VUE_APP_API_URL}/api/files/upload/${id}`, {
        method: "POST",
        body: data,
        headers: {
          "userId": id
        }
      }).then(response => {
        // Log the response to the console
        console.log(response)
        // If the response is successful, return the JSON data
        if (response.ok) return response.json();
      }).catch(err => {
        // Log any errors to the console
        console.log(err);
      }).then(data => {
        // Set the fileId property to the returned file id
        // Set the fileId property to the returned file id
        this.fileId = data.id;
        // Emit the fileId event with the file id as the argument
        this.$emit('fileId', this.fileId);
      }).catch(err => {
        // Log any errors to the console
        console.log(err);
      })
    },

  },

  setup() {
    let theSkills = []
    axios.get(process.env.VUE_APP_API_URL + `/api/skills`)
        .then((res) => {
          theSkills = res.data;
          console.log(theSkills)
        })
        .catch((err) => {
          console.log(err);
        })

    const toast = useToast();

    let searchTerm = ref('')

    const selectSkill = (skill) => {
      selectedSkill.value = skill
      searchTerm.value = ''
    }

    const searchSkills = computed(() => {
      if (searchTerm.value === '') {
        return []
      }

      let matches = 0

      return theSkills.filter(skill => {
        if (
            skill.name.toLowerCase().includes(searchTerm.value.toLowerCase())
            && matches < 10
        ) {
          matches++
          return skill
        }
      })
    });

    let selectedSkill = ref('')

    return {
      theSkills,
      searchTerm,
      searchSkills,
      selectSkill,
      selectedSkill
    }
  },

}
</script>

<style scoped>

</style>