package com.javarush.test.level21.lesson08.task02;

import java.util.Arrays;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

        Tree tree1 = new Tree(null, new String[]{"s1", null, "s3", "s4"});
        Tree clone1 = null;
        try {
            clone1 = tree1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree1);
        System.out.println(clone1);

        System.out.println(tree1.branches);
        System.out.println(clone1.branches);

        System.out.println(tree1.getName()+ " "+Arrays.toString(tree1.getBranches()));
        System.out.println(clone1.getName()+ " "+Arrays.toString(clone1.getBranches()));
        for (int i = 0 ; i<tree1.getBranches().length; i++) {
            System.out.println(tree1.getBranches()[i]==clone1.getBranches()[i]);
        }
        clone1.getBranches()[0]= "kdfjbgkjdf";
        System.out.println(tree1.getName()+ " "+Arrays.toString(tree1.getBranches()));
        System.out.println(clone1.getName()+ " "+Arrays.toString(clone1.getBranches()));
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        protected Tree clone() throws CloneNotSupportedException
        {
            String cloneName=null;
            if (getName()!=null)
            {
                cloneName = new String(getName());
            }
            String[] cloneBranches = null;
            if (getBranches()!=null)
            {
                cloneBranches = getBranches().clone();
            }
            /*for (int i = 0; i < getBranches().length; i++) {
                String str = null;
                if (getBranches()[i]!=null)
                {
                    str = new String(getBranches()[i]);
                }
                cloneBranches[i] = str;
            }*/
            Tree clone= new Tree(cloneName, cloneBranches);
            return clone;
        }
    }
}
