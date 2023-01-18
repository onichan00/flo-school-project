import { mount } from "@vue/test-utils";
import Dashboard from "@/views/admin/dashboard";

/**
 * Test suite for the Dashboard component
 */
describe("Dashboard.vue", () => {
    let wrapper;

    /**
     * Create a new instance of the wrapper before each test
     */
    beforeEach(() => {
        wrapper = mount(Dashboard);
    });

    /**
     * Test that the component correctly displays "Loading..." when data is empty
     */
    it("displays 'Loading...' when data is empty", () => {
        wrapper.setData({ data: [] });
        expect(wrapper.text()).toContain("Loading...");
    });
});
