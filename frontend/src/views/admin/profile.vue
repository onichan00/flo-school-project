<template>
  <div class="m-4 rounded-lg overflow-hidden shadow shadow-md">
    <div class="w-full h-48 banner" />
      <div class="h-24 flex flex-row justify-between">
        <img
            class="w-40 h-40 rounded-full ring-8 ring-white object-cover absolute -mt-20 ml-8"
            src="https://images.unsplash.com/photo-1558203728-00f45181dd84?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2074&q=80"
            alt="Bordered avatar"
        >
      <div />
      <button @click="openEditUserInfoModal" type="button" class="m-4 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center">
        <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"></path></svg>
        <span class="sr-only">Edit Profile</span>
      </button>
    </div>
    <div class="w-full text-left px-8 py-4">
      <p class="text-2xl">[FULL NAME]</p>
      <p class="text-gray-400">[CITY] - [SPECIALIST TYPE]</p>
      <p class="mt-4">[BIO]</p>

      <div class="mt-4">
        <p class="font-medium">Attachments</p>
        <ul class="w-full text-sm font-medium text-gray-900 bg-white rounded-lg border border-gray-200 divide-y">
          <li v-for="(attachment, index) in attachments" :key="index" class="py-2 px-4 w-full flex flex-row justify-between items-center">
            <span class="flex flex-row gap-2">
              <svg class="w-5 h-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.172 7l-6.586 6.586a2 2 0 102.828 2.828l6.414-6.586a4 4 0 00-5.656-5.656l-6.415 6.585a6 6 0 108.486 8.486L20.5 13"></path></svg>
              {{ attachment.name }}
            </span>
            <a href="#" class="font-medium text-blue-600 hover:underline">Download</a>
          </li>
        </ul>
      </div>

      <!-- TODO - Add to project buttons -->
<!--      <div class="flex flex-row space-x-2 mt-4">-->
<!--        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 focus:outline-none">Default</button>-->
<!--        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 focus:outline-none">Default</button>-->
<!--      </div>-->
    </div>
  </div>

  <!-- Skills -->
  <div class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
    <p class="text-xl mb-4">Skills</p>
    <div class="grid grid-cols-3 gap-4 mb-8">
      <SkillBadge v-for="(skill, index) in skills" :key="index" :skill="skill" @skillClicked="openSkillModal"/>

      <button @click="openSkillModal(null)" class="bg-green-100 text-green-900 p-4 rounded-md flex items-center justify-center">
        <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v6m0 0v6m0-6h6m-6 0H6"></path></svg>
      </button>
    </div>

  </div>

  <!-- Projects -->
  <div class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
    <p class="text-xl mb-4">Projects</p>
    <div class="grid grid-cols-4 gap-4 mb-8">
      <ProjectCard v-for="(item, index) in projects" :key="index" :project="item" />
    </div>
  </div>

  <!-- Available Hours -->
  <div class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
    <p class="text-xl">Availability</p>
    <div class="">

    </div>
  </div>

  <!-- Calendar -->
  <div class="m-4 rounded-lg px-8 py-4 text-left shadow shadow-md">
    <p class="text-xl">Upcoming meetings</p>

    <div class="flex flex-row">
      <div class="w-2/3 pr-10">
        <div class="divide-y">
          <UpcomingMeeting v-for="(meeting, index) in futureMeetings" :key="index" :meeting="meeting" @meetingClicked="openUpcomingMeetingModal"/>
        </div>

<!--        <div class="flex flex-row items-center">-->
<!--          <button v-if="firstPage" @click="previousPage" class="inline-flex items-center px-4 py-2 mr-3 text-sm font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">-->
<!--            <svg aria-hidden="true" class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M7.707 14.707a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 1.414L5.414 9H17a1 1 0 110 2H5.414l2.293 2.293a1 1 0 010 1.414z" clip-rule="evenodd"></path></svg>-->
<!--            Previous-->
<!--          </button>-->
<!--          <button v-if="lastPage" @click="nextPage" class="inline-flex items-center px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">-->
<!--            Next-->
<!--            <svg aria-hidden="true" class="w-5 h-5 ml-2" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>-->
<!--          </button>-->
<!--        </div>-->
      </div>
      <div class="w-1/3 flex flex-col">
        <v-calendar is-expanded :attributes="attributes">
          <template #day-popover="{ dayTitle, attributes }">
            <div class="text-xs text-gray-300 font-semibold text-center">
              {{ dayTitle }}
            </div>
            <calendar-row
              v-for="attr in attributes"
              :key="attr.key"
              :attribute="attr"
              @click="openUpcomingMeetingModal(attr.customData)"
              class="cursor-pointer"
            >
              {{ attr.customData.title }}
            </calendar-row>
          </template>
        </v-calendar>
        <button @click="openUpcomingMeetingModal(null)" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mt-2">Add meeting</button>
      </div>
    </div>
  </div>


  <!-- Main modal -->
  <div id="defaultModal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
    <div class="relative w-full h-full max-w-2xl md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow">
        <!-- Modal header -->
        <div class="flex items-center justify-between py-4 px-6 border-b rounded-t">
          <h3 class="text-xl font-semibold text-gray-900">
            Skill
          </h3>
          <button type="button" @click="closeSkillModal" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            <span class="sr-only">Close modal</span>
          </button>
        </div>
        <!-- Modal body -->
        <div class="p-6 space-y-6 text-left">

          <div>
            <label for="skillSelect" class="text-lg font-medium text-gray-900">Please
              select a new skill</label>
            <select id="skillSelect" v-model="selectedSkill.name"
                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-florijnOrange-100 focus:border-florijnOrange-200 block w-full p-2.5">
              <option selected disabled value="">Please select an skill</option>
              <option v-for="(skill, index) in skills" :key="index" :value="skill.name">{{ skill.name }}</option>
            </select>
          </div>

          <div>
            <label for="understanding-novice" class="text-lg font-medium text-gray-900">Rate your skill level</label>
            <ul class="grid gap-4 w-full md:grid-cols-3">
              <li>
                <input type="radio" id="understanding-novice" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=0 required>
                <label for="understanding-novice"
                       class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">1</div>
                    <div class="w-full">Novice</div>
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-competence" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=1 required>
                <label for="understanding-competence"
                       class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">2</div>
                    <div class="w-full">Competence</div>
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-proficiency" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=2 required>
                <label for="understanding-proficiency"
                       class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">3</div>
                    <div class="w-full">Proficiency</div>
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-expert" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=3 required>
                <label for="understanding-expert"
                       class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">4</div>
                    <div class="w-full">Expert</div>
                  </div>
                </label>
              </li>
              <li>
                <input type="radio" id="understanding-mastery" name="understanding" class="hidden peer" v-model="selectedSkill.level" :value=4 required>
                <label for="understanding-mastery"
                       class="inline-flex justify-between items-center p-5 w-full text-gray-500 bg-white rounded-lg border border-gray-200 cursor-pointer peer-checked:border-florijnOrange-100 peer-checked:text-florijnOrange-100 hover:text-gray-600 hover:bg-florijnOrange-100/10 hover:border-florijnOrange-100/10">
                  <div class="block">
                    <div class="w-full text-lg font-semibold">5</div>
                    <div class="w-full">Mastery</div>
                  </div>
                </label>
              </li>
            </ul>

          </div>
        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
          <button @click="saveSkill" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
          <button @click="closeSkillModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
        </div>
      </div>
    </div>
  </div>

  <!-- Edit User Info -->
  <div id="editUserInfo" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
    <div class="relative w-full h-full max-w-4xl md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <!-- Modal header -->
        <div class="flex items-center justify-between p-4 border-b rounded-t">
          <h3 class="text-xl font-semibold text-gray-900">
            Edit User Info
          </h3>
          <button @click="closeEditUserInfoModal" type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            <span class="sr-only">Close modal</span>
          </button>
        </div>
        <!-- Modal body -->
        <div class="p-6 space-y-6 text-left">
          <div class="flex items-center justify-center w-full">
            <label for="dropzone-file" class="flex flex-col items-center justify-center w-full h-64 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
              <div class="flex flex-col items-center justify-center pt-5 pb-6">
                <svg aria-hidden="true" class="w-10 h-10 mb-3 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path></svg>
                <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Click to upload</span></p>
                <p class="text-xs text-gray-500 dark:text-gray-400">PNG or JPG (MAX. 800x400px)</p>
              </div>
              <input id="dropzone-file" type="file" class="hidden" />
            </label>
          </div>
          <div class="mb-6">
            <label for="email" class="block mb-2 text-sm font-medium text-gray-900">Email address</label>
            <input type="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="john.doe@company.com" required>
          </div>
          <div class="grid gap-4 mb-6 md:grid-cols-3">
            <div>
              <label for="first_name" class="block mb-2 text-sm font-medium text-gray-900">First name</label>
              <input type="text" id="first_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="John" required>
            </div>
            <div>
              <label for="second_name" class="block mb-2 text-sm font-medium text-gray-900">Second name</label>
              <input type="text" id="second_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Cornelis" required>
            </div>
            <div>
              <label for="last_name" class="block mb-2 text-sm font-medium text-gray-900">Last name</label>
              <input type="text" id="last_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Doe" required>
            </div>
          </div>
          <div class="grid gap-4 mb-6 md:grid-cols-2">
            <div>
              <label for="city" class="block mb-2 text-sm font-medium text-gray-900">City</label>
              <input type="text" id="first_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Amsterdam" required>
            </div>
            <div>
              <label for="zipcode" class="block mb-2 text-sm font-medium text-gray-900">Zipcode</label>
              <input type="text" id="second_name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="1000AA" required>
            </div>
          </div>
          <div class="mb-6">
            <label for="address" class="block mb-2 text-sm font-medium text-gray-900">Address</label>
            <input type="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Wibautstraat 4B" required>
          </div>
          <div class="mb-6">
            <label for="bio" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Bio</label>
            <textarea id="bio" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="Write your bio here..."></textarea>
          </div>
        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
          <button @click="closeEditUserInfoModal" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
          <button @click="closeEditUserInfoModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
        </div>
      </div>
    </div>
  </div>

  <!-- Upcoming Meeting Modal -->
  <div id="upcomingMeetingModal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
    <div class="relative w-full h-full max-w-2xl md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <!-- Modal header -->
        <div class="flex items-start justify-between p-4 border-b rounded-t dark:border-gray-600">
          <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
            {{ selectedMeeting.title }}
          </h3>
          <button type="button" @click="closeUpcomingMeetingModal" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            <span class="sr-only">Close modal</span>
          </button>
        </div>
        <!-- Modal body -->
        <div class="p-6 space-y-6 text-left">
          <div>
            <div class="flex flex-row gap-2 w-full mb-2">
              <div class="w-1/2">
                <label for="meetingStart" class="block mb-2 text-sm font-medium text-gray-900">Start</label>
                <DatePicker :lang="langObj" class="w-full" type="datetime" format="DD-MM-YYYY HH:mm" :showMinute="true" :showSecond="false" :minute-step="5" id="meetingStart" v-model:value="selectedMeeting.start"/>
              </div>
              <div class="w-1/2">
                <label for="meetingEnd" class="block mb-2 text-sm font-medium text-gray-900">End</label>
                <DatePicker :lang="langObj" class="w-full" type="datetime" format="DD-MM-YYYY HH:mm" :showMinute="true" :showSecond="false" :minute-step="5" id="meetingEnd" v-model:value="selectedMeeting.end"/>
              </div>
            </div>
            <div class="flex items-center">
              <input id="checked-checkbox" type="checkbox" value="" class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 focus:ring-2">
              <label for="checked-checkbox" class="ml-2 text-sm font-medium text-gray-900">Full day</label>
            </div>
          </div>

<!--          <form class="bg-white shadow-md rounded px-8 pt-6 pb-8" @submit.prevent>-->
<!--            <div class="mb-4">-->
<!--      <span class="block text-gray-600 text-sm text-left font-bold mb-2"-->
<!--      >Select Range</span-->
<!--      >-->
<!--          &lt;!&ndash; TODO https://vcalendar.io/examples/datepickers.html &ndash;&gt;-->
<!--              <v-date-picker-->
<!--                  v-model="selectedMeeting"-->
<!--                  mode="dateTime"-->
<!--                  :masks="masks"-->
<!--                  is-range-->
<!--              >-->
<!--                <template v-slot="{ inputEvents, isDragging }">-->
<!--                  <div class="flex flex-col sm:flex-row justify-start items-center">-->
<!--                    <div class="relative flex-grow">-->
<!--                      <svg-->
<!--                          class="text-gray-600 w-4 h-full mx-2 absolute pointer-events-none"-->
<!--                          fill="none"-->
<!--                          stroke-linecap="round"-->
<!--                          stroke-linejoin="round"-->
<!--                          stroke-width="2"-->
<!--                          viewBox="0 0 24 24"-->
<!--                          stroke="currentColor"-->
<!--                      >-->
<!--                        <path-->
<!--                            d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"-->
<!--                        ></path>-->
<!--                      </svg>-->
<!--                      <input-->
<!--                          class="flex-grow pl-8 pr-2 py-1 bg-gray-100 border rounded w-full"-->
<!--                          :class="isDragging ? 'text-gray-600' : 'text-gray-900'"-->
<!--                          :value="selectedMeeting.start"-->
<!--                          v-on="inputEvents.start"-->
<!--                      />-->
<!--                    </div>-->
<!--                    <span class="flex-shrink-0 m-2">-->
<!--              <svg-->
<!--                  class="w-4 h-4 stroke-current text-gray-600"-->
<!--                  viewBox="0 0 24 24"-->
<!--              >-->
<!--                <path-->
<!--                    stroke-linecap="round"-->
<!--                    stroke-linejoin="round"-->
<!--                    stroke-width="2"-->
<!--                    d="M14 5l7 7m0 0l-7 7m7-7H3"-->
<!--                />-->
<!--              </svg>-->
<!--            </span>-->
<!--                    <div class="relative flex-grow">-->
<!--                      <svg-->
<!--                          class="text-gray-600 w-4 h-full mx-2 absolute pointer-events-none"-->
<!--                          fill="none"-->
<!--                          stroke-linecap="round"-->
<!--                          stroke-linejoin="round"-->
<!--                          stroke-width="2"-->
<!--                          viewBox="0 0 24 24"-->
<!--                          stroke="currentColor"-->
<!--                      >-->
<!--                        <path-->
<!--                            d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"-->
<!--                        ></path>-->
<!--                      </svg>-->
<!--                      <input-->
<!--                          class="flex-grow pl-8 pr-2 py-1 bg-gray-100 border rounded w-full"-->
<!--                          :class="isDragging ? 'text-gray-600' : 'text-gray-900'"-->
<!--                          :value="selectedMeeting.end"-->
<!--                          v-on="inputEvents.end"-->
<!--                      />-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </template>-->
<!--              </v-date-picker>-->
<!--            </div>-->
<!--          </form>-->

          <div>
            <label for="title" class="block mb-2 text-sm font-medium text-gray-900">Title</label>
            <input type="title" id="email" v-model="selectedMeeting.title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Going for lunch with..." required>
          </div>

          <div>
            <label for="type" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select an option</label>
            <select id="type" v-model="selectedMeeting.type" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
              <option selected disabled value="-1">Choose a schedule type</option>
              <option value="0">Meeting</option>
              <option value="1">Free day</option>
              <option value="2">Vacation</option>
            </select>
          </div>

          <div>
            <label for="location" class="block mb-2 text-sm font-medium text-gray-900">Location</label>
            <input type="location" id="email" v-model="selectedMeeting.location" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Wibautstraat 4b" required>
          </div>

          <div>
            <label for="message" class="block mb-2 text-sm font-medium text-gray-900">Description</label>
            <textarea id="message" rows="4" v-model="selectedMeeting.description" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="What is this meeting about..."></textarea>
          </div>

        </div>
        <!-- Modal footer -->
        <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
          <button @click="saveUpcomingMeeting" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Save</button>
          <button @click="closeUpcomingMeetingModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">Cancel</button>
        </div>
      </div>
    </div>
  </div>

</template>
<script>
import { ref } from 'vue';
import SkillBadge from "@/components/miscellaneous/profile/SkillBadge";
import Skill from "@/models/skill";
import UpcomingMeetingClass from "@/models/upcomingMeeting";
import ProjectCard from "@/components/miscellaneous/ProjectCard";
import UpcomingMeeting from "@/components/miscellaneous/profile/UpcomingMeeting";
import DatePicker from 'vue-datepicker-next';
import CalendarRow from "@/components/miscellaneous/profile/CalendarRow";

import 'vue-datepicker-next/index.css';
import 'v-calendar/dist/style.css';

export default {
  name: "UserProfile",
  data() {
    return {
      langObj: {
        formatLocale: {
          firstDayOfWeek: 1
        }
      },
      meetingPagination: {
        meetingPerPage: 3,
        currentPage: 0,
      },
      skillModal: null,
      editUserInfoModal: null,
      upcomingMeetingModal: null,
      selectedSkill: new Skill(),
      selectedMeeting: new UpcomingMeetingClass(),
      masks: {
        input: 'YYYY-MM-DD hh:mm',
      },
      skills: [
        {
          "name": "Java",
          "level": 4,
        },
        {
          "name": "Dart",
          "level": 4,
        },
        {
          "name": "Python",
          "level": 2,
        },
        {
          "name": "C++",
          "level": 0,
        },
        {
          "name": "JavaScript",
          "level": 2,
        },
      ],
      projects: [
        {
          "name": "Project 1",
          "status": 0
        },
        {
          "name": "Project 2",
          "status": 1
        },
        {
          "name": "Project 3",
          "status": 0
        },
        {
          "name": "Project 4",
          "status": 2
        }
      ],
      attachments: [
        {
          "name": "resume_front_end_developer.pdf"
        },
        {
          "name": "coverletter_front_end_developer.pdf"
        }
      ],
      upcomingMeetings: [
        {
          "title": "Meeting with Apple",
          "start": new Date(2022, 11, 8, 17, 0),
          "end": new Date(2022, 11, 8, 18, 0),
          "location": "Starbucks",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 0
        },
        {
          "title": "Family Vacation",
          "start": new Date(2022, 11, 10, 10, 0),
          "end": new Date(2022, 11, 15, 18, 0),
          "location": "Starbucks",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 2
        },
        {
          "title": "Meeting with Leslie Alexander",
          "start": new Date(2023, 0, 10, 17, 0),
          "end": new Date(2023, 0, 10, 18, 0),
          "location": "Starbucks",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 0
        },
        {
          "title": "Meeting with Michale Foster",
          "start": new Date(2023, 0, 12, 15, 0),
          "end": new Date(2023, 0, 12, 16, 0),
          "location": "Costa Coffee at Behead",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 2
        },
        {
          "title": "Meeting with Dries Vincent",
          "start": new Date(2023, 0, 12, 17, 0),
          "end": new Date(2023, 0, 12, 18, 0),
          "location": "Tim Hortons",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 1
        },
        {
          "title": "Meeting with Lindsay Walton",
          "start": new Date(2023, 0, 14, 10, 0),
          "end": new Date(2023, 0, 14, 11, 0),
          "location": "Silver-burn",
          "description": "LOREM IPSUM DESCRIPTION",
          "type": 0
        },
        {
          "title": "Meeting with Leslie Alexander",
          "start": new Date(2023, 0, 14, 12, 0),
          "end": new Date(2023, 0, 14, 13, 0),
          "location": "The Glasgow Green",
          "description": "LOREM IPSUM",
          "type": 2
        }
      ],
    }
  },
  computed: {
    attributes() {
      return [
          ...this.upcomingMeetings.map(meeting => this.meetingFormat(meeting))
      ]
    },
    futureMeetings() {
      const now = new Date();
      const meetings = [];

      this.upcomingMeetings.forEach(meeting => {
        if (this.getEpochTime(meeting.end) > this.getEpochTime(now)) {
          meetings.push(meeting);
        }
      })

      return meetings;
    },
  },
  mounted() {
    // eslint-disable-next-line no-undef
    this.skillModal = new Modal(document.querySelector("#defaultModal"));
    // eslint-disable-next-line no-undef
    this.editUserInfoModal = new Modal(document.querySelector("#editUserInfo"));
    // eslint-disable-next-line no-undef
    this.upcomingMeetingModal = new Modal(document.querySelector("#upcomingMeetingModal"));
  },
  methods: {
    meetingFormat(meeting) {
      const multiDayMeeting = {
        highlight: {
          start: { fillMode: 'outline', color: this.getMeetingType(meeting.type) },
          base: { fillMode: 'light', color: this.getMeetingType(meeting.type) },
          end: { fillMode: 'outline', color: this.getMeetingType(meeting.type) },
        },
        dates: { start: meeting.start, end: meeting.end },
        popover: {
          label: meeting.title,
          visibility: 'focus',
          isInteractive: true
        },
        customData: meeting
      }

      const sameDayMeeting = {
        dates: [meeting.start, meeting.end],
        popover: {
          label: meeting.title,
          visibility: 'focus',
          isInteractive: true
        },
        dot: {
          color: this.getMeetingType(meeting.type)
        },
        customData: meeting
      }

      return this.sameDay(meeting.start, meeting.end) ? sameDayMeeting : multiDayMeeting;
    },
    getMeetingType(type) {
      // Available Colors: gray, red, orange, yellow, green, teal, blue, indigo, purple, pink
      let color;

      switch (type) {
        case 0: // Meeting
          color = "orange"
          break;
        case 1: // Free day
          color = "teal";
          break;
        case 2: // Vacation
          color = "green"
          break;
        default:
          color = "red";
      }

      return color;
    },
    sameDay(start, end) {
      return start.getFullYear() === end.getFullYear() &&
          start.getMonth() === end.getMonth() &&
          start.getDate() === end.getDate()
    },
    getEpochTime(date) {
      return date.getTime() / 1000;
    },

    previousPage() {
      console.log("Previous Page");
      this.meetingPagination.currentPage--;
    },
    nextPage() {
      console.log("Next Page");
      this.meetingPagination.currentPage++;
    },

    printPopoverData(day, format, masks, hide, attributes) {
      console.log(day, format, masks, hide, attributes);
    },

    openSkillModal(n) {
      console.log(n);
      this.selectedSkill = new Skill(n);
      this.skillModal.show();
    },
    closeSkillModal() {
      this.skillModal.hide();
    },
    saveSkill() {
      // TODO Check if item already exists. Check on ID
      this.skills.push(this.selectedSkill)
      this.closeSkillModal();
    },

    openEditUserInfoModal() {
      this.editUserInfoModal.show();
    },
    closeEditUserInfoModal() {
      this.editUserInfoModal.hide();
    },

    openUpcomingMeetingModal(meeting) {
      console.log(meeting);
      this.selectedMeeting = new UpcomingMeetingClass(meeting);
      this.upcomingMeetingModal.show();
    },
    closeUpcomingMeetingModal() {
      this.upcomingMeetingModal.hide();
    },

    saveUpcomingMeeting() {
      this.upcomingMeetings.push(new UpcomingMeetingClass(this.selectedMeeting));

      this.closeUpcomingMeetingModal();
    }
  },
  components: {
    UpcomingMeeting,
    ProjectCard,
    SkillBadge,
    DatePicker,
    CalendarRow
  }
}
</script>
<style>
  .banner {
    background-image: linear-gradient(to right, #F15922 , #f17822)
  }

  .mx-input {
    background-color: #f9fafb !important;
    border-width: 1px !important;
    border-color: #d1d5db !important;
    color: #111827 !important;
    border-radius: 0.5rem !important;
    font-size: 0.875rem !important; /* 14px */
    line-height: 1.25rem !important; /* 20px */
    padding: 0.625rem !important; /* 10px */
    box-shadow: 0px 0px 0px 0px rgba(0,0,0,0) !important;
  }
</style>