<template>
  <aside
      @mouseenter="toggleSidebar(false)"
      @mouseleave="toggleSidebar(true)"
      id="sidebar" class="h-full overflow-y-hidden" :style="{width: sidebarWidth}" aria-label="Sidebar">
    <div class="overflow-y-auto flex flex-col justify-between h-full py-4  px-3 border-solid border-r-2">
      <div>
          <span v-if="collapsed">
          <h1 style="font-weight: 900; font-size: 40px; color: #F15922;">F</h1>
        </span>
        <span v-else>
          <h1 style="font-weight: 900; font-size: 40px; color: #F15922;">FLORIJN</h1>
        </span>

        <hr>

        <div>

          <ul class="space-y-2 mt-2">

            <SidebarLink to="/admin" icon="fas fa-dashboard"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Dashboard
            </SidebarLink>
            <!--            <SidebarLink to="/notifications" icon="fas fa-bell"
                                     class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
                          Notifications
                        </SidebarLink>-->

            <SidebarLink to="/specialists/applications" icon="fas fa-users"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Aanmeldingen
            </SidebarLink>
            <SidebarLink to="/projects" icon="fas fa-diagram-project"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Projecten
            </SidebarLink>

            <SidebarLink to="/admin/admins" icon="fa-solid fa-user"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Admins
            </SidebarLink>

            <SidebarLink to="/specialists" icon="fas fa-code"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Specialisten
            </SidebarLink>

            <SidebarLink to="/clients" icon="fa-solid fa-money-bill-trend-up"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Cliënten
            </SidebarLink>
          </ul>

        </div>
      </div>

      <div>

        <div>

          <ul class="space-y-2 mt-2">
            <SidebarLink @click="logout" to="/login" icon="fas fa-right-from-bracket"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Logout
            </SidebarLink>

          </ul>

        </div>

      </div>

    </div>
  </aside>
</template>

<script>
import SidebarLink from './SidebarLink'
import {collapsed, sidebarWidth, toggleSidebar} from './state'

export default {
  name: "ComponentsSidebar",
  props: {},
  components: {SidebarLink},
  setup() {
    return {collapsed, toggleSidebar, sidebarWidth}
  },
  methods: {
    push(){
      this.$router.push("/profile/" + localStorage.getItem("id"))
    },
    logout() {
      localStorage.clear()
      this.$router.push("/").then(() => {
        this.$router.go()
      })
    }
  }
}
</script>

<style scoped>
#sidebar {
  color: white;
  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease;
  display: flex;
  flex-direction: column;
  background-color: white;
}
</style>
