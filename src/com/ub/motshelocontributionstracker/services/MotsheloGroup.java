package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;
import java.util.ArrayList;

public class MotsheloGroup
{
    private String groupName;
    private ArrayList<Member> members;
    private int currentPayoutIndex;

    public MotsheloGroup(String groupName)
    {
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.currentPayoutIndex = 0;
    }

    public void addMember(Member m)
    {
      if (m == null) throw new IllegalArgumentException("Member cannot be null");
      
      members.add(m);
    }

    public ArrayList<Member> getMembers()
    {
        return members;
    }

    public Member getNextPayoutMember()
    {
      if (members.isEmpty())
      {
          return null;
      }
    return members.get(currentPayoutIndex);
    }

    public void moveToNextMember()
    {
        if (!members.isEmpty())
        {
            currentPayoutIndex = (currentPayoutIndex + 1) % members.size();
        }
    }

      @Override
          public String toString()
          {
              String next = members.isEmpty() ? "None" : getNextPayoutMember().getName();
              return "Group: " + groupName + " | Members: " + members.size() + " | Next payout: " + next;
          }
}
