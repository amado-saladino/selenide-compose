# Selenide with docker compose

Run Selenide tests with Maven and TestNG, the stack has three services:

- test: run tests with maven
- report: nginx-based container that publish the test report
- gallery: view snapshots taken during test run as an album

## Run the stack

```shell
docker-compose up -d
```

## Regression test

```shell
docker-compose start test
```

## Test entrypoint

The service `test` in this stack is overriden with a shell script `entrypoint.sh`

This shell copies the test report files and contents to the volume where `report` service loads the report files

## Test report

```
http://localhost:80
```

## Snapshot gallery

```
http://localhost:81
```

## Test service image

The image used for `test` service is `amadosaladino/se` which has a default entry point `mvn`

If run this image as a standlone container, it will run this command by default:

```shell
mvn clean test
```

But in this case, we need to override this entrypoint to copy the test report from `test` container to `report` container