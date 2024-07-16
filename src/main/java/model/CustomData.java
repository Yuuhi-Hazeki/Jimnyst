package model;

public class CustomData {
	private String id;
	  private String imgPass;
	    private String title;
	    private String customSus;
	    private String customBody;
	    private String customEngine;

	    // ゲッターとセッター
	    public String getImgPass() {
	        return imgPass;
	    }

	    public void setImgPass(String ImgPass) {
	        this.imgPass = ImgPass;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCustomSus() {
	        return customSus;
	    }

	    public void setCustomSus(String CustomSus) {
	        this.customSus = CustomSus;
	    }

	    public String getCustomBody() {
	        return customBody;
	    }

	    public void setCustomBody(String CustomBody) {
	        this.customBody = CustomBody;
	    }

	    public String getCustomEngine() {
	        return customEngine;
	    }

	    public void setCustomEngine(String CustomEngine) {
	        this.customEngine = CustomEngine;
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	
	}