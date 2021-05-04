package main;

import util.InputUtil;
import util.MenuUtil;

public class Main {

    public static void main(String[] args) {

        while(true){

            int menu = InputUtil.inputNumber("Menu:" +
                    "\n1. Telebe qeydiyyati" +
                    "\n2. Telebe siyahisi" +
                    "\n3. Telebe melumatlarini deyishmek" +
                    "\n4. Telebe tapmaq" +
                    "\n5. Chixish" +
                    "\n\nSeciminiz: ");

            MenuUtil.processMenu(menu);

            System.out.println("****************************");
        }

    }
}
