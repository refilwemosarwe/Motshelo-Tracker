package com.ub.motshelocontributionstracker.services;

import com.ub.motshelocontributionstracker.profile.Member;
import java.util.ArrayList;

public class MotsheloGroup
{
    private String groupName; // the name of the group
    private ArrayList<Member> members; // list of all members in the group
    private int currentPayoutIndex; // tracks whose turn it is

    public MotsheloGroup(String groupName)
    {
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.currentPayoutIndex = 0;
    }

    public void addMember(Member m)  // Adds a new member to the group
    {
      if (m == null) throw new IllegalArgumentException("Member cannot be null"); // Avoids adding an null member
      
      members.add(m);
    }

    public ArrayList<Member> getMembers()
    {
        return members; // Gives out the full list of members in the group
    }

    public Member getNextPayoutMember() // Show the member whose turn it is to receive the next payout
    {
      if (members.isEmpty())
      {
          return null; // Returns null if there are no members
      }
    return members.get(currentPayoutIndex);
    }

    public void moveToNextMember() // It moves to the next member in the motshelo after a payout has been made
    {
        if (!members.isEmpty())
        {
            currentPayoutIndex = (currentPayoutIndex + 1) % members.size(); // Keeps the rotation in check and causes it to repeat after last member received payout
        }
    }

      @Override
          public String toString()
          {
              String next = members.isEmpty() ? "None" : getNextPayoutMember().getName();
              return "Group: " + groupName + " | Members: " + members.size() + " | Next payout: " + next;
              // Shows a summary of the group: name, how many members, and who is next in receiving the money
          }
}
