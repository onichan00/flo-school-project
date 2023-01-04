import { mount } from "@vue/test-utils";
import SkillBadge from "@/components/miscellaneous/profile/SkillBadge.vue";

let wrapper;

beforeAll(() => {
    const propData = {
        skill: {
            name: "Java",
            level: 4
        }
    }

    wrapper = mount(SkillBadge, {
        props: propData
    })
})

describe('Skills', () => {
    it('Should emit open on click', () => {
        // Click on the badge
        wrapper.trigger("click");

        // Catch the emit event
        const wrapperEvent = wrapper.emitted('skillClicked')[0][0];

        // The emit event should have been called
        expect(wrapperEvent).toBeTruthy();
    })
});