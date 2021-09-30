package br.com.automacao.ultils;

	public enum BrowserTypes
	{
		CHROME_WINDOWS_HEADLESS("CHROME-WINDOWS-HEADLESS"),
		CHROME_WINDOWS_WEB("CHROME_WINDOWS_WEB"),
		CHROME_LINUX_HEADLESS("CHROME_LINUX_HEADLESS"),
		CHROME_LINUX_WEB("CHROME_LINUX_WEB");

		String label;

		private BrowserTypes(String label)
		{
			this.label = label;
		}

		public String getLabel()
		{
			return this.label;
		}

		public String toString()
		{
			return this.label;
		}
	}

