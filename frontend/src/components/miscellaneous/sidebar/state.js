import { ref, computed } from 'vue';

export const collapsed = ref(true);
export const toggleSidebar = state => (collapsed.value = state);

export const SIDEBAR_WIDTH = 260;
export const SIDEBAR_WIDTH_COLLAPSED = 100;
export const sidebarWidth = computed(
    () => `${collapsed.value ? SIDEBAR_WIDTH_COLLAPSED : SIDEBAR_WIDTH}px`
);