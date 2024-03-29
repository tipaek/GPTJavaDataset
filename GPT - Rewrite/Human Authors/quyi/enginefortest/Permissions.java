/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.nercis.isscp.idl.permission;

/**
 * 定义android的所有权限
 */
public enum Permissions implements org.apache.thrift.TEnum {
  ACCESS_CHECKIN_PROPERTIES(0),
  ACCESS_COARSE_LOCATION(1),
  ACCESS_FINE_LOCATION(2),
  ACCESS_LOCATION_EXTRA_COMMANDS(3),
  ACCESS_MOCK_LOCATION(4),
  ACCESS_NETWORK_STATE(5),
  ACCESS_SURFACE_FLINGER(6),
  ACCESS_WIFI_STATE(7),
  ACCOUNT_MANAGER(8),
  ADD_VOICEMAIL(9),
  AUTHENTICATE_ACCOUNTS(10),
  BATTERY_STATS(11),
  BIND_ACCESSIBILITY_SERVICE(12),
  BIND_APPWIDGET(13),
  BIND_DEVICE_ADMIN(14),
  BIND_INPUT_METHOD(15),
  BIND_NFC_SERVICE(16),
  BIND_NOTIFICATION_LISTENER_SERVICE(17),
  BIND_PRINT_SERVICE(18),
  BIND_REMOTEVIEWS(19),
  BIND_TEXT_SERVICE(20),
  BIND_VPN_SERVICE(21),
  BIND_WALLPAPER(22),
  BLUETOOTH(23),
  BLUETOOTH_ADMIN(24),
  BLUETOOTH_PRIVILEGED(25),
  BRICK(26),
  BROADCAST_PACKAGE_REMOVED(27),
  BROADCAST_SMS(28),
  BROADCAST_STICKY(29),
  BROADCAST_WAP_PUSH(30),
  CALL_PHONE(31),
  CALL_PRIVILEGED(32),
  CAMERA(33),
  CAPTURE_AUDIO_OUTPUT(34),
  CAPTURE_SECURE_VIDEO_OUTPUT(35),
  CAPTURE_VIDEO_OUTPUT(36),
  CHANGE_COMPONENT_ENABLED_STATE(37),
  CHANGE_CONFIGURATION(38),
  CHANGE_NETWORK_STATE(39),
  CHANGE_WIFI_MULTICAST_STATE(40),
  CHANGE_WIFI_STATE(41),
  CLEAR_APP_CACHE(42),
  CLEAR_APP_USER_DATA(43),
  CONTROL_LOCATION_UPDATES(44),
  DELETE_CACHE_FILES(45),
  DELETE_PACKAGES(46),
  DEVICE_POWER(47),
  DIAGNOSTIC(48),
  DISABLE_KEYGUARD(49),
  DUMP(50),
  EXPAND_STATUS_BAR(51),
  FACTORY_TEST(52),
  FLASHLIGHT(53),
  FORCE_BACK(54),
  GET_ACCOUNTS(55),
  GET_PACKAGE_SIZE(56),
  GET_TASKS(57),
  GET_TOP_ACTIVITY_INFO(58),
  GLOBAL_SEARCH(59),
  HARDWARE_TEST(60),
  INJECT_EVENTS(61),
  INSTALL_LOCATION_PROVIDER(62),
  INSTALL_PACKAGES(63),
  INSTALL_SHORTCUT(64),
  INTERNAL_SYSTEM_WINDOW(65),
  INTERNET(66),
  KILL_BACKGROUND_PROCESSES(67),
  LOCATION_HARDWARE(68),
  MANAGE_ACCOUNTS(69),
  MANAGE_APP_TOKENS(70),
  MANAGE_DOCUMENTS(71),
  MASTER_CLEAR(72),
  MEDIA_CONTENT_CONTROL(73),
  MODIFY_AUDIO_SETTINGS(74),
  MODIFY_PHONE_STATE(75),
  MOUNT_FORMAT_FILESYSTEMS(76),
  MOUNT_UNMOUNT_FILESYSTEMS(77),
  NFC(78),
  PERSISTENT_ACTIVITY(79),
  PROCESS_OUTGOING_CALLS(80),
  READ_CALENDAR(81),
  READ_CALL_LOG(82),
  READ_CONTACTS(83),
  READ_EXTERNAL_STORAGE(84),
  READ_FRAME_BUFFER(85),
  READ_HISTORY_BOOKMARKS(86),
  READ_INPUT_STATE(87),
  READ_LOGS(88),
  READ_PHONE_STATE(89),
  READ_PROFILE(90),
  READ_SMS(91),
  READ_SOCIAL_STREAM(92),
  READ_SYNC_SETTINGS(93),
  READ_SYNC_STATS(94),
  READ_USER_DICTIONARY(95),
  REBOOT(96),
  RECEIVE_BOOT_COMPLETED(97),
  RECEIVE_MMS(98),
  RECEIVE_SMS(99),
  RECEIVE_WAP_PUSH(100),
  RECORD_AUDIO(101),
  REORDER_TASKS(102),
  RESTART_PACKAGES(103),
  SEND_RESPOND_VIA_MESSAGE(104),
  SEND_SMS(105),
  SET_ACTIVITY_WATCHER(106),
  SET_ALARM(107),
  SET_ALWAYS_FINISH(108),
  SET_ANIMATION_SCALE(109),
  SET_DEBUG_APP(110),
  SET_ORIENTATION(111),
  SET_POINTER_SPEED(112),
  SET_PREFERRED_APPLICATIONS(113),
  SET_PROCESS_LIMIT(114),
  SET_TIME(115),
  SET_TIME_ZONE(116),
  SET_WALLPAPER(117),
  SET_WALLPAPER_HINTS(118),
  SIGNAL_PERSISTENT_PROCESSES(119),
  STATUS_BAR(120),
  SUBSCRIBED_FEEDS_READ(121),
  SUBSCRIBED_FEEDS_WRITE(122),
  SYSTEM_ALERT_WINDOW(123),
  TRANSMIT_IR(124),
  UNINSTALL_SHORTCUT(125),
  UPDATE_DEVICE_STATS(126),
  USE_CREDENTIALS(127),
  USE_SIP(128),
  VIBRATE(129),
  WAKE_LOCK(130),
  WRITE_APN_SETTINGS(131),
  WRITE_CALENDAR(132),
  WRITE_CALL_LOG(133),
  WRITE_CONTACTS(134),
  WRITE_EXTERNAL_STORAGE(135),
  WRITE_GSERVICES(136),
  WRITE_HISTORY_BOOKMARKS(137),
  WRITE_PROFILE(138),
  WRITE_SECURE_SETTINGS(139),
  WRITE_SETTINGS(140),
  WRITE_SMS(141),
  WRITE_SOCIAL_STREAM(142),
  WRITE_SYNC_SETTINGS(143),
  WRITE_USER_DICTIONARY(144);

  private final int value;

  private Permissions(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Permissions findByValue(int value) { 
    switch (value) {
      case 0:
        return ACCESS_CHECKIN_PROPERTIES;
      case 1:
        return ACCESS_COARSE_LOCATION;
      case 2:
        return ACCESS_FINE_LOCATION;
      case 3:
        return ACCESS_LOCATION_EXTRA_COMMANDS;
      case 4:
        return ACCESS_MOCK_LOCATION;
      case 5:
        return ACCESS_NETWORK_STATE;
      case 6:
        return ACCESS_SURFACE_FLINGER;
      case 7:
        return ACCESS_WIFI_STATE;
      case 8:
        return ACCOUNT_MANAGER;
      case 9:
        return ADD_VOICEMAIL;
      case 10:
        return AUTHENTICATE_ACCOUNTS;
      case 11:
        return BATTERY_STATS;
      case 12:
        return BIND_ACCESSIBILITY_SERVICE;
      case 13:
        return BIND_APPWIDGET;
      case 14:
        return BIND_DEVICE_ADMIN;
      case 15:
        return BIND_INPUT_METHOD;
      case 16:
        return BIND_NFC_SERVICE;
      case 17:
        return BIND_NOTIFICATION_LISTENER_SERVICE;
      case 18:
        return BIND_PRINT_SERVICE;
      case 19:
        return BIND_REMOTEVIEWS;
      case 20:
        return BIND_TEXT_SERVICE;
      case 21:
        return BIND_VPN_SERVICE;
      case 22:
        return BIND_WALLPAPER;
      case 23:
        return BLUETOOTH;
      case 24:
        return BLUETOOTH_ADMIN;
      case 25:
        return BLUETOOTH_PRIVILEGED;
      case 26:
        return BRICK;
      case 27:
        return BROADCAST_PACKAGE_REMOVED;
      case 28:
        return BROADCAST_SMS;
      case 29:
        return BROADCAST_STICKY;
      case 30:
        return BROADCAST_WAP_PUSH;
      case 31:
        return CALL_PHONE;
      case 32:
        return CALL_PRIVILEGED;
      case 33:
        return CAMERA;
      case 34:
        return CAPTURE_AUDIO_OUTPUT;
      case 35:
        return CAPTURE_SECURE_VIDEO_OUTPUT;
      case 36:
        return CAPTURE_VIDEO_OUTPUT;
      case 37:
        return CHANGE_COMPONENT_ENABLED_STATE;
      case 38:
        return CHANGE_CONFIGURATION;
      case 39:
        return CHANGE_NETWORK_STATE;
      case 40:
        return CHANGE_WIFI_MULTICAST_STATE;
      case 41:
        return CHANGE_WIFI_STATE;
      case 42:
        return CLEAR_APP_CACHE;
      case 43:
        return CLEAR_APP_USER_DATA;
      case 44:
        return CONTROL_LOCATION_UPDATES;
      case 45:
        return DELETE_CACHE_FILES;
      case 46:
        return DELETE_PACKAGES;
      case 47:
        return DEVICE_POWER;
      case 48:
        return DIAGNOSTIC;
      case 49:
        return DISABLE_KEYGUARD;
      case 50:
        return DUMP;
      case 51:
        return EXPAND_STATUS_BAR;
      case 52:
        return FACTORY_TEST;
      case 53:
        return FLASHLIGHT;
      case 54:
        return FORCE_BACK;
      case 55:
        return GET_ACCOUNTS;
      case 56:
        return GET_PACKAGE_SIZE;
      case 57:
        return GET_TASKS;
      case 58:
        return GET_TOP_ACTIVITY_INFO;
      case 59:
        return GLOBAL_SEARCH;
      case 60:
        return HARDWARE_TEST;
      case 61:
        return INJECT_EVENTS;
      case 62:
        return INSTALL_LOCATION_PROVIDER;
      case 63:
        return INSTALL_PACKAGES;
      case 64:
        return INSTALL_SHORTCUT;
      case 65:
        return INTERNAL_SYSTEM_WINDOW;
      case 66:
        return INTERNET;
      case 67:
        return KILL_BACKGROUND_PROCESSES;
      case 68:
        return LOCATION_HARDWARE;
      case 69:
        return MANAGE_ACCOUNTS;
      case 70:
        return MANAGE_APP_TOKENS;
      case 71:
        return MANAGE_DOCUMENTS;
      case 72:
        return MASTER_CLEAR;
      case 73:
        return MEDIA_CONTENT_CONTROL;
      case 74:
        return MODIFY_AUDIO_SETTINGS;
      case 75:
        return MODIFY_PHONE_STATE;
      case 76:
        return MOUNT_FORMAT_FILESYSTEMS;
      case 77:
        return MOUNT_UNMOUNT_FILESYSTEMS;
      case 78:
        return NFC;
      case 79:
        return PERSISTENT_ACTIVITY;
      case 80:
        return PROCESS_OUTGOING_CALLS;
      case 81:
        return READ_CALENDAR;
      case 82:
        return READ_CALL_LOG;
      case 83:
        return READ_CONTACTS;
      case 84:
        return READ_EXTERNAL_STORAGE;
      case 85:
        return READ_FRAME_BUFFER;
      case 86:
        return READ_HISTORY_BOOKMARKS;
      case 87:
        return READ_INPUT_STATE;
      case 88:
        return READ_LOGS;
      case 89:
        return READ_PHONE_STATE;
      case 90:
        return READ_PROFILE;
      case 91:
        return READ_SMS;
      case 92:
        return READ_SOCIAL_STREAM;
      case 93:
        return READ_SYNC_SETTINGS;
      case 94:
        return READ_SYNC_STATS;
      case 95:
        return READ_USER_DICTIONARY;
      case 96:
        return REBOOT;
      case 97:
        return RECEIVE_BOOT_COMPLETED;
      case 98:
        return RECEIVE_MMS;
      case 99:
        return RECEIVE_SMS;
      case 100:
        return RECEIVE_WAP_PUSH;
      case 101:
        return RECORD_AUDIO;
      case 102:
        return REORDER_TASKS;
      case 103:
        return RESTART_PACKAGES;
      case 104:
        return SEND_RESPOND_VIA_MESSAGE;
      case 105:
        return SEND_SMS;
      case 106:
        return SET_ACTIVITY_WATCHER;
      case 107:
        return SET_ALARM;
      case 108:
        return SET_ALWAYS_FINISH;
      case 109:
        return SET_ANIMATION_SCALE;
      case 110:
        return SET_DEBUG_APP;
      case 111:
        return SET_ORIENTATION;
      case 112:
        return SET_POINTER_SPEED;
      case 113:
        return SET_PREFERRED_APPLICATIONS;
      case 114:
        return SET_PROCESS_LIMIT;
      case 115:
        return SET_TIME;
      case 116:
        return SET_TIME_ZONE;
      case 117:
        return SET_WALLPAPER;
      case 118:
        return SET_WALLPAPER_HINTS;
      case 119:
        return SIGNAL_PERSISTENT_PROCESSES;
      case 120:
        return STATUS_BAR;
      case 121:
        return SUBSCRIBED_FEEDS_READ;
      case 122:
        return SUBSCRIBED_FEEDS_WRITE;
      case 123:
        return SYSTEM_ALERT_WINDOW;
      case 124:
        return TRANSMIT_IR;
      case 125:
        return UNINSTALL_SHORTCUT;
      case 126:
        return UPDATE_DEVICE_STATS;
      case 127:
        return USE_CREDENTIALS;
      case 128:
        return USE_SIP;
      case 129:
        return VIBRATE;
      case 130:
        return WAKE_LOCK;
      case 131:
        return WRITE_APN_SETTINGS;
      case 132:
        return WRITE_CALENDAR;
      case 133:
        return WRITE_CALL_LOG;
      case 134:
        return WRITE_CONTACTS;
      case 135:
        return WRITE_EXTERNAL_STORAGE;
      case 136:
        return WRITE_GSERVICES;
      case 137:
        return WRITE_HISTORY_BOOKMARKS;
      case 138:
        return WRITE_PROFILE;
      case 139:
        return WRITE_SECURE_SETTINGS;
      case 140:
        return WRITE_SETTINGS;
      case 141:
        return WRITE_SMS;
      case 142:
        return WRITE_SOCIAL_STREAM;
      case 143:
        return WRITE_SYNC_SETTINGS;
      case 144:
        return WRITE_USER_DICTIONARY;
      default:
        return null;
    }
  }
}
