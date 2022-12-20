package com.solvd.hospital.reflectionapi;


import com.solvd.hospital.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.Arrays;


public class Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        //получение класса, родителя класса
        Class clazz = Class.forName("com.solvd.hospital.Hospital");
        Class superClass = clazz.getSuperclass();
        //инициализация нашего объекта с помощью  reflection
        Hospital hospital = (Hospital) clazz.getDeclaredConstructor().newInstance();

        LOGGER.info("Название класса-наследника: " + superClass.getName() + ", Название нашего класса: " + clazz.getName() + "\n");

        //получение списка конструкторов
        Constructor[] constructors = clazz.getConstructors();
        Constructor[] superConstructors = superClass.getConstructors();

        LOGGER.info("Кол-во конструкторов родителя: " + superConstructors.length + ", Кол-во конструкторов нашего класса:" + constructors.length + "\n");

        //получение инфы о параметрах в конструкторе класса
        for (Constructor c :
                constructors) {
            Class[] params = c.getParameterTypes();

            for (Class param :
                    params) {
                LOGGER.info(param.getName() + "\n");
            }
        }

        //информация про поле(даже с модификатором private), поэтому getFields() не катит
        Field[] classFields = hospital.getClass().getDeclaredFields();
        Arrays.stream(classFields).forEach(field -> {
            field.setAccessible(true);
            try {
                LOGGER.info("\n Тип данных: " + field.getType()
                        + "\n Название поля " + field.getName()
                        + "\n Значение " + field.get(hospital));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        //получение доступа к private полю и изменение его
        Field nameOfHospital = hospital.getClass().getDeclaredField("nameOfHospital");
        nameOfHospital.setAccessible(true);
        LOGGER.info("Old value: " + nameOfHospital.get(hospital));
        nameOfHospital.set(hospital, "Это теперь база НАТО");
        LOGGER.info("New value: " + nameOfHospital.get(hospital) + "\n");

        //получение информации о методах
        Method[] methods = hospital.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(method ->
                LOGGER.info("\nТип возвращаемого значения: " + method.getReturnType()
                        + "\n Модификаторы доступа: " + Modifier.toString(method.getModifiers())
                        + "\n Название метода: " + method.getName()
                        + "\n Входные параметры: " + Arrays.toString(method.getParameters()) + "\n")
        );

        //вызов метода
        Method method = hospital.getClass().getDeclaredMethod("getHospitalOptions");
        LOGGER.info(method.invoke(hospital).toString());
    }
}
