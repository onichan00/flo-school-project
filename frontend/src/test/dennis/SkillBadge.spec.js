import { mount } from "@vue/test-utils";
import SkillBadge from "@/components/miscellaneous/profile/SkillBadge.vue";

let wrapper

const userSkill = { id: 1, level: 4, skill: { id: 1, name: 'JavaScript' } };

beforeAll(() => {
    wrapper = mount(SkillBadge, {
        props: {
            skill: userSkill
        }
    });
});

describe('SkillBadge', function () {
    it('Should render skill name in button', async () => {
        expect(wrapper.find('button').text()).toBe('JavaScript');
    })

    it('Should emit skillClicked event with skill when button is clicked', () => {
        wrapper.find('button').trigger('click');

        expect(wrapper.emitted('skillClicked')).toEqual([[ userSkill ]])
    })
});