using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FirstToSecondPage : MonoBehaviour {

	public void changeMenu(string sceneName) 
	{
		Application.LoadLevel(sceneName);
	}
}
