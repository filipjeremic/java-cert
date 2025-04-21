package kettu;

abstract sealed class Cutlery permits Fork, Knife, Spoon {
}

// prohibited
// class Sword extends Cutlery {}

final class Fork extends Cutlery {
}

sealed class Spoon extends Cutlery permits Teaspoon {
}

final class Teaspoon extends Spoon {
}

non-sealed class Knife extends Cutlery {
}

// permitted
class Sword extends Knife {
}

// --------------------------------------------------

sealed interface Parent permits Mother, Father {
}

final class Mother implements Parent {
}

final class Father implements Parent {
}

// --------------------------------------------------

public class SealedTypesDemo {

}
