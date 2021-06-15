package com.questions.concept.enums;

public class Engine {

    private EngineType engineType;

    public Engine(EngineType engineType) {
        this.engineType = engineType;
    }

    public void start(){
        engineType.start();
    }

    public void stop(){
        engineType.stop();
    }

    enum EngineType{
        TWO_STROKE_ENGINE {
            @Override
            void start() {
                System.out.println(String.format("%s got started", getClass().getName()));
            }

            @Override
            void stop() {
                System.out.println(String.format("%s got stopped", getClass().getName()));
            }
        }, FOUR_STROKE_ENGINE {
            @Override
            void start() {
                System.out.println(String.format("%s got started", getClass().getName()));
            }

            @Override
            void stop() {
                System.out.println(String.format("%s got stopped", getClass().getName()));
            }
        };

        abstract void start();
        abstract void stop();
    }
}
