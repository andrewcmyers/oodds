Maybe<String> m = ...;

String new_s = m.then(s -> "(" + s + ")")
                .orElse("");

