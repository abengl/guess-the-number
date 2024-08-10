public interface MusicalInstrument {
    void play();
}

class Guitar implements MusicalInstrument {
    @Override
    public void play() {
        System.out.println("🎸🎸🎸🎸🎸🎸");
    }
}

class Piano implements MusicalInstrument {
    @Override
    public void play() {
        System.out.println("\uD83C\uDFB9\uD83C\uDFB9\uD83C\uDFB9\uD83C\uDFB9\uD83C\uDFB9\uD83C\uDFB9");
    }
}
