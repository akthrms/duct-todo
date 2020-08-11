## SETUP

```
$ docker-compose build

$ docker-compose run repl lein new duct duct-todo +api +ataraxy +postgres

$ mv duct-todo/* duct-todo/.* .
```

## REPL

```
$ docker-compose run --service-ports repl

nREPL server started on port 39998 on host 0.0.0.0 - nrepl://0.0.0.0:39998
```
