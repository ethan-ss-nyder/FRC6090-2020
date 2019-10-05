# FRC6090-2020: Infinite Recharge
The official repository of Team 6090's 2020 infinite recharge code, vision, and dashboard configurations.

## Versions Table
These tables store the latest versions of the software we use. Note that these are the latest versions *that work with FRC and WpiLib*.

| Vendor Libraries | Latest Known Version |
|------------------|----------------------|
| WPILib           | 2019.4.1             |
| NavX             | 3.1.366              |
| CTRE Phoenix     | 5.14.1               |
| RevRobotics      | 1.1.9                |

| Software         | Latest Known Version |
|------------------|----------------------|
| OpenJDK          | 11.0.4 (LTS)         |
| Gradle           | 5.6.2                |
| FRC Update Suite | 2019.2.0             |
| VS Code          | 1.38.1               |
| Git              | 2.23.0               |
| Phoenix Tuner    | 1.4.0                |
| Spark Max Client | 1.0.0                |
| Etcher           | 1.5.57               |

| Firmware  | Latest known Version |
|-----------|----------------------|
| Spark Max | 1.1.4                |
| RoboRIO   | 6.0.0                |

| Images    | Latest Known Version |
|-----------|----------------------|
| RoboRIO   | 2019.14              |
| LimeLight | 2019.7.1             |

## Competition Checklist
- [ ] Update Laptops
    - [ ] Windows Update
    - [ ] Code (always ` git pull` and `git checkout` the current competition branch)
    - [ ] **See versions table for software updates**
- [ ] Ensure laptop functionality
    - [ ] Driver Station
    - [ ] Dashboard
    - [ ] Code can be modified and deployed
- [ ] Charge laptops

## Contributors
- Jordan Bancino
- Ethan Snyder
- Collin Heavner
- Jude Dobry
- Stephen Harnish

## Building & Deploying
### Common Issues
- Gradle may fail to resolve some dependencies. If this happens, you'll need to run this command to manually download
them: 

        $ gradle downloadAll

- Gradle may not be able to find Java. Make sure you add `java` to the system path, and set the `JAVA_HOME` environment variable. You may have to restart your IDE after making these changes.

## Limelight Configurations
As well as code, this repository contains the LimeLight configurations used at competitions. These are found in the `limelight-conf/` directory. Each `.vpr` file is a pipeline, and can be uploaded to a Limelight for immediate use. As the Limelight configurations change, these pipeline files are updated.

## Shuffleboard
Shuffleboard is the experimental dashboard used this season. The exact layout used is in `shuffleboard.json`. As the Shuffleboard layout is changed, this file is updated.

## Contributing
TODO: add contributing guide here.
