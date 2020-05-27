import model.*;
import oop.model.*;

import java.time.LocalDate;

public class TestLab5 {

    public static void lab5tests() {
        Service[] services = new Service[3];
        services[0] = new Service();
        Service service;

        try {
            service = new Service(null, 123, ServiceTypes.MAIL, LocalDate.now());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            service = new Service("sdf", -123, ServiceTypes.MAIL, LocalDate.now());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            service = new Service("sgg", 123, null, LocalDate.now());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            service = new Service("sdfg", 123, ServiceTypes.MAIL, LocalDate.MAX);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        for (Service s : tariff.getServices(ServiceTypes.INTERNET)) {
            System.out.println(s.toString());
            System.out.println(s.hashCode());
            System.out.println(s.equals(new Service()));
            System.out.println(s.equals(new Service("asd", 123, ServiceTypes.MAIL, LocalDate.now())));
            try {
                System.out.println(s.clone().toString());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println(s.getActivationDate());
        }

        Person person = new Person("Ivan", "Ivanov");
        //Person person1 = new Person(null, "Ivanov");
        //Person person2 = new Person("Ivan", null);
        System.out.println(person.toString());
        System.out.println(person.hashCode());
        System.out.println(person.equals(new Person("Ivan", "Ivanov")));
        System.out.println(person.equals(new Person("Ivvan", "Ivanov")));

        Tariff entityTariff = new EntityTariff();
        entityTariff.add(new Service("asd", 123, ServiceTypes.MAIL, LocalDate.now().minusDays(13)));
        System.out.println(entityTariff.toString());
        System.out.println(entityTariff.hashCode());
        System.out.println(entityTariff.equals(new EntityTariff()));
        Tariff entityTariff2 = new EntityTariff();
        entityTariff2.add(new Service("asd", 123, ServiceTypes.MAIL, LocalDate.now()));
        System.out.println(entityTariff.equals(entityTariff2));
        try {
            System.out.println(entityTariff.clone().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(entityTariff.cost());
        System.out.println(entityTariff.indexOf(new Service()));
        System.out.println(entityTariff.lastIndexOf(new Service()));
        System.out.println(entityTariff.remove(new Service()));
        try {
            System.out.println(entityTariff.remove(45));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(entityTariff.remove(-6));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(entityTariff.add(455, new Service()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(entityTariff.set(455, new Service()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(entityTariff.get(455));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        Tariff individualsTariff = new IndividualsTariff();
        individualsTariff.add(new Service());
        System.out.println(individualsTariff.toString());
        System.out.println(individualsTariff.hashCode());
        System.out.println(individualsTariff.equals(new IndividualsTariff()));
        Tariff individualsTariff2 = new IndividualsTariff();
        individualsTariff2.add(new Service());
        System.out.println(individualsTariff.equals(individualsTariff2));
        try {
            System.out.println(individualsTariff.clone().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        individualsTariff.set(3, new Service("asd", 123, ServiceTypes.MAIL, LocalDate.now().minusDays(12)));
        individualsTariff.set(0, new Service("asd", 123, ServiceTypes.MAIL, LocalDate.now()));
        individualsTariff.set(0, new Service());
        System.out.println(individualsTariff.cost());
        System.out.println(individualsTariff.indexOf(new Service()));
        System.out.println(individualsTariff.lastIndexOf(new Service()));
        System.out.println(individualsTariff.remove(new Service()));
        try {
            System.out.println(individualsTariff.remove(45));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(individualsTariff.remove(-6));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(individualsTariff.add(455, new Service()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(individualsTariff.set(455, new Service()));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(individualsTariff.get(455));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        Account account = new IndividualAccount(0xE8D4A51001L,
                new Person("Ivan", "Ivanov"), (IndividualsTariff) tariff, LocalDate.now());
        AbstractAccount account1 = new IndividualAccount(0x738D7EA4C67FFFL,
                new Person("Petr", "Petrov"), new IndividualsTariff(), LocalDate.now());

        try {
            account1.setTariff(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            account1 = new IndividualAccount(0x738D7EA4C67FFFL,
                    new Person("Petr", "Petrov"), null, LocalDate.now());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            AbstractAccount account2 = new IndividualAccount(0x738D7EA4C67FFFL,
                    new Person("Petr", "Petrov"), new IndividualsTariff(), LocalDate.MAX);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            IndividualAccount a = new IndividualAccount(0x738D7EA4C67FFFL,
                    null, new IndividualsTariff(), LocalDate.now());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            IndividualAccount a = new IndividualAccount(0x738D7EA4C67FFFL,
                    null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            IndividualAccount a = new IndividualAccount(0x738D7EA4C67FFFL,
                    new Person("Petr", "Petrov"));
            a.setPerson(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(account1.toString());
        System.out.println(account1.hashCode());
        System.out.println(account1.equals(account));
        System.out.println(account1.getRegistrationDate());

        System.out.println(account.toString());
        System.out.println(account.hashCode());

        try {
            Account entityAccount = new EntityAccount(0x738D7EA4C67FFFL,null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            Account entityAccount1 = new EntityAccount(0x738D7EA4C67FFFL,null, entityTariff, LocalDate.now());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            EntityAccount entityAccount1 = new EntityAccount(0x738D7EA4C67FFFL,"sfw", entityTariff, LocalDate.now());
            entityAccount1.setName(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        Account entityAccount = new EntityAccount(0x738D7EA4C67FFFL,"Petr");
        Account entityAccount1 = new EntityAccount(0x738D7EA4C67FFFL,"Petr", entityTariff, LocalDate.now());
        System.out.println(entityAccount.toString());
        System.out.println(entityAccount.hashCode());
        System.out.println(entityAccount.equals(entityAccount1));


        Account[] accounts = new Account[3];
        accounts[0] = account;
        accounts[1] = entityAccount;
        AccountsManager manager = new AccountsManager(accounts);
        System.out.println(manager.toString());
        System.out.println(manager.indexOf(account));
        System.out.println(manager.remove(account));

        try {
            manager.getAccount(3);
        } catch (IllegalAccountNumber e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.getTariff(3);
        } catch (IllegalAccountNumber e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.setTariff(3, tariff);
        } catch (IllegalAccountNumber e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.add(account);
        } catch (DublicateAccountNumberException e) {
            e.printStackTrace();
        }
        try {
            manager.add(account);
        } catch (DublicateAccountNumberException e) {
            e.printStackTrace();
        }

        manager.getEntityAccount();

    }

    @org.junit.Test
    public void startTests() {
        lab5tests();
    }

}
