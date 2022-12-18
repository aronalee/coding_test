// prob: https://school.programmers.co.kr/learn/courses/30/lessons/49993

package programmers.스킬트리;

public class Solution {

    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        for (final String skillTree : skillTrees) {
            boolean possibleLearning = possibleLearnTree(skill, skillTree);
            if (possibleLearning) {
                answer++;
            }
        }
        return answer;
    }

    private boolean possibleLearnTree(final String skill, final String skillTree) {
        char[] subSkills = skill.toCharArray();
        char[] skillsInTree = skillTree.toCharArray();
        int subSkillIdx = 0;
        for (final char skillInTree : skillsInTree) {
            if (subSkillIdx >= subSkills.length) {
                return true;
            }
            char subSkill = subSkills[subSkillIdx];
            if (skillInTree == subSkill) {
                subSkillIdx++;
                continue;
            }
            boolean hasJumpSkill = hasJumpSkillInTree(subSkills, skillInTree, subSkillIdx);
            if (hasJumpSkill) {
                return false;
            }
        }
        return true;
    }

    private boolean hasJumpSkillInTree(final char[] subSkills, final char skillInTree
        , final int currentSubSkillIdx) {
        for (int i = currentSubSkillIdx + 1; i < subSkills.length; i++) {
            char subSkill = subSkills[i];
            if (subSkill == skillInTree) {
                return true;
            }
        }
        return false;
    }

}
