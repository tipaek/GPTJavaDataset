package com.yeshj.pacman;

public final class MediaInfo {

	private static boolean jniLoaded = false;
	private String videoFormat;
	private String audioFormat;

	static {
		try {
			if ("\\".equals(System.getProperties().getProperty("file.separator"))) {
				System.loadLibrary("libMediaInfo");
			} else {
				System.loadLibrary("zen");
				System.loadLibrary("media");
				System.loadLibrary("MediaInfo");
			}
			jniLoaded = true;
		} catch (UnsatisfiedLinkError e) {
			jniLoaded = false;
			e.printStackTrace();
		}
	}

	public boolean analyzeMedia(String mediaFile) {
		return jniLoaded && nativeAnalyzeMedia(mediaFile);
	}

	public String getMediaTypeKey() {
		return jniLoaded ? nativeGetMediaType() : "UNKNOWN";
	}

	public String getVideoFormat() {
		if (jniLoaded && (videoFormat == null || videoFormat.trim().isEmpty())) {
			videoFormat = nativeGetVideoCodec();
		}
		return videoFormat != null ? videoFormat : "UNKNOWN";
	}

	public String getAudioFormat() {
		if (jniLoaded && (audioFormat == null || audioFormat.trim().isEmpty())) {
			audioFormat = nativeGetAudioCodec();
		}
		return audioFormat != null ? audioFormat : "UNKNOWN";
	}

	public int getWidth() {
		return jniLoaded ? nativeGetWidth() : -1;
	}

	public int getHeight() {
		return jniLoaded ? nativeGetHeight() : -1;
	}

	public int getAudioBitrate() {
		return jniLoaded ? nativeGetAudioBitrate() : -1;
	}

	public int getVideoBitrate() {
		return jniLoaded ? nativeGetVideoBitrate() : -1;
	}

	public int getAudioSamplingRate() {
		return jniLoaded ? nativeGetSamplingRate() : -1;
	}

	public long getAudioDuration() {
		return jniLoaded ? nativeGetAudioDuration() : -1;
	}

	public long getVideoDuration() {
		return jniLoaded ? nativeGetVideoDuration() : -1;
	}

	public boolean isAudioOnly() {
		String vformat = getVideoFormat();
		return vformat == null || "UNKNOWN".equalsIgnoreCase(vformat) || vformat.isEmpty();
	}

	public void release() {
		if (jniLoaded) {
			nativeRelease();
		}
	}

	private native boolean nativeAnalyzeMedia(String mediaFile);

	private native String nativeGetMediaType();

	private native String nativeGetAudioCodec();

	private native String nativeGetVideoCodec();

	private native int nativeGetWidth();

	private native int nativeGetHeight();

	private native int nativeGetAudioBitrate();

	private native int nativeGetVideoBitrate();

	private native int nativeGetSamplingRate();

	private native long nativeGetAudioDuration();

	private native long nativeGetVideoDuration();

	private native void nativeRelease();
}
