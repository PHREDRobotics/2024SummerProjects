// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final double k2pi = Math.PI * 2;

  /**
   * General constants for the robot's build
   */
  public static final class ModuleConstants {
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
    public static final double kDriveMotorGearRatio = 1 / 6.75;
    public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
    public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
    public static final double kDriveWheelFreeRps = NeoMotorConstants.kFreeSpeedRpm / 60;

    // public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio;
    public static final int kTurnMotorEncoderTicksPerRotation = 42;
    public static final double kTurningMotorRotationPerSteerRotation = 150 / 7;
    public static final double kTurningEncoderRot2Rad = kTurningMotorRotationPerSteerRotation
        * kTurnMotorEncoderTicksPerRotation;
    public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;

    public static final double kTurningMotorPositionFactor = k2pi; // Radians
    public static final double kTurningEncoderPositionPIDMinInput = 0; // Radians
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningMotorPositionFactor; // Radians

    public static final double kDrivingP = 0.4;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;
    public static final double kDrivingFF = 1 / kDriveWheelFreeRps;
    public static final double kDrivingMinInput = -1;
    public static final double kDrivingMaxOutput = 1;

    public static final double kPTurning = 1;
    public static final double kITurning = 0;
    public static final double kDTurning = 0;
    public static final double kFFTurning = 0;
    public static final double kTurningMinInput = -1;
    public static final double kTurningMaxOutput = 1;

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

    public static final int kDrivingMotorCurrentLimit = 50; // amps
    public static final int kTurningMotorCurrentLimit = 20; // amps

  }

  /**
   * Constants for the neo motors
   */
  public final static class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
  }

  /**
   * Constants for the controller
   */
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;

    public static final int kDriverYAxis = Axis.kLeftY.value;
    public static final int kDriverXAxis = Axis.kLeftX.value;
    public static final int kDriverRotAxis = Axis.kRightX.value;
    public static final int kDriverFieldOrientedButtonIdx = Button.kB.value;
    public static final int kLeftTriggerAxis = Axis.kLeftTrigger.value;
    public static final int kRightTriggerAxis = Axis.kRightTrigger.value;

    public static final int kStartButton = Button.kStart.value;
    public static final int kLeftBumper = Button.kLeftBumper.value;
    public static final int kRightBumper = Button.kRightBumper.value;
    public static final int kXButton = Button.kX.value;
    public static final int kYButton = Button.kY.value;
    public static final int kAButton = Button.kA.value;
    public static final int kBButton = Button.kB.value;

    public static final double kDeadband = 0.15;
    public static final double kHighDeadband = 0.25;

  }

  /**
   * Constants for driving
   */
  public static final class DriveConstants {
    // Distance between right and left wheels in inches
    public static final double kTrackWidth = Units.inchesToMeters(24.5);
    // Distance between front and back wheels in inches
    public static final double kWheelBase = Units.inchesToMeters(24.5);
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

    public static final int kBackLeftDriveMotorPort = 21;
    public static final int kFrontLeftDriveMotorPort = 11;
    public static final int kFrontRightDriveMotorPort = 16;
    public static final int kBackRightDriveMotorPort = 26;

    public static final int kBackLeftTurningMotorPort = 22;
    public static final int kFrontLeftTurningMotorPort = 12;
    public static final int kFrontRightTurningMotorPort = 17;
    public static final int kBackRightTurningMotorPort = 27;

    public static final boolean kFrontLeftTurningEncoderReversed = false;
    public static final boolean kBackLeftTurningEncoderReversed = false;
    public static final boolean kFrontRightTurningEncoderReversed = false;
    public static final boolean kBackRightTurningEncoderReversed = false;

    public static final boolean kFrontLeftDriveEncoderReversed = true;
    public static final boolean kBackLeftDriveEncoderReversed = true;
    public static final boolean kFrontRightDriveEncoderReversed = false;
    public static final boolean kBackRightDriveEncoderReversed = false;

    public static final boolean kFrontLeftDriveInverted = true;
    public static final boolean kBackLeftDriveInverted = false;
    public static final boolean kFrontRightDriveInverted = true;
    public static final boolean kBackRightDriveInverted = true;

    // public static final int kFrontLeftDriveAbsoluteEncoderPort = 12;
    // public static final int kBackLeftDriveAbsoluteEncoderPort = 22;
    // public static final int kFrontRightDriveAbsoluteEncoderPort = 17;
    // public static final int kBackRightDriveAbsoluteEncoderPort = 27;

    public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

    public static final double kFrontLeftModuleChassisAngularOffset = 0;
    public static final double kBackLeftModuleChassisAngularOffset = 0;
    public static final double kFrontRightModuleChassisAngularOffset = 0;
    public static final double kBackRightModuleChassisAngularOffset = 0;

    public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * k2pi;

    public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
        kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;

    public static final double kTeleDriveThrottleMultiplier = 1;
  }

  public static final class VisionConstants {
    public static final double kLimelightMountAngleDegrees = 0.0;
    public static final double kLimelightLensHeightInches = 0.0;
    public static final double kAmpOrSourceHeightInches = 48.5;
    public static final double kSpeakerHeightInches = 51.0 + 7.0 / 8.0;
    public static final double kStageHeightInches = 47.5;
  }
}
