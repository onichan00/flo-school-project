  <template>
  <aside id="sidebar" class="h-full overflow-y-hidden" :style="{width: sidebarWidth}" aria-label="Sidebar">
    <div @click="toggleSidebar"
         class="overflow-y-auto flex flex-col justify-between h-full py-4  px-3 border-solid border-r-2">
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

            <SidebarLink to="/dashboard" icon="fas fa-dashboard"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Dashboard
            </SidebarLink>
            <SidebarLink to="/notifications" icon="fas fa-bell"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Notifications
            </SidebarLink>
            <SidebarLink to="/specialists" icon="fas fa-code"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Specialists
            </SidebarLink>
            <SidebarLink to="/recruiters" icon="fas fa-users"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Recruiters
            </SidebarLink>
            <SidebarLink to="/projects" icon="fas fa-diagram-project"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Projects
            </SidebarLink>

          </ul>

        </div>
      </div>

      <div>

        <div>

          <ul class="space-y-2 mt-2">

            <SidebarLink to="/settings" icon="fas fa-gear"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Settings
            </SidebarLink>
            <SidebarLink to="/profile" icon="fas fa-user"
                         class="flex items-center p-2 text-base font-normal text-gray-900 rounded-md dark:text-white hover:bg-orange-100 dark:hover:bg-gray-700">
              Profile
            </SidebarLink>
            <SidebarLink to="/logout" icon="fas fa-right-from-bracket"
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
import {collapsed, toggleSidebar, sidebarWidth} from './state'

export default {
  name: "ComponentsSidebar",
  props: {},
  components: {SidebarLink},
  setup() {
    return {collapsed, toggleSidebar, sidebarWidth}
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
